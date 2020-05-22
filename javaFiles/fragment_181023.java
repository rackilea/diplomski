private List<Group> loadGroups(File file) throws IOException {
    try (InputStream in = new FileInputStream(file)) {
        ClassParser parser = new ClassParser(in, file.getName());
        JavaClass clazz = parser.parse();
        String className = clazz.getClassName();
        ConstantPoolGen cp = new ConstantPoolGen(clazz.getConstantPool());
        List<Group> groups = new ArrayList<Group>();
        for (Field field: clazz.getFields()) {
            groups.add(new Group().addFields(field.getName()));
        }
        for (Method method: clazz.getMethods()) {
            Group group = new Group().addMethods(method.getName());
            Code code = method.getCode();
            InstructionList instrs = new InstructionList(code.getCode());
            for (InstructionHandle ih: instrs) {
                Instruction instr = ih.getInstruction();
                if (instr instanceof FieldInstruction) {
                    FieldInstruction fld = (FieldInstruction)instr;
                    if (fld.getClassName(cp).equals(className)) {
                        group.addFields(fld.getFieldName(cp));
                    }
                } else if (instr instanceof InvokeInstruction) {
                    InvokeInstruction inv = (InvokeInstruction)instr;
                    if (inv.getClassName(cp).equals(className)) {
                        group.addMethods(inv.getMethodName(cp));
                    }
                }
            }
            if (group.fields() > 0 || group.methods() > 1) {
                int i = groups.size();
                while (i > 0) {
                    --i;
                    Group g = groups.get(i);
                    if (g.intersects(group)) {
                        group.merge(g);
                        groups.remove(i);
                    }
                }
                groups.add(group);
            }
        }
        return groups;
    }
}