private void dumpMyDataClass() throws IOException, BadBytecode, Exception {
    ClassFile cf = new ClassFile(new DataInputStream(getClass().getResourceAsStream("MyData.class")));

    // Dump fields:
    for (Object fieldInfoObj : cf.getFields()) {
        FieldInfo fieldInfo = (FieldInfo) fieldInfoObj;
        System.out.printf("Field %s; %s%n", fieldInfo.getName(), fieldInfo.getDescriptor());
    }

    MethodInfo minfo = cf.getMethod("add");
    CodeAttribute ca = minfo.getCodeAttribute();
    for (CodeIterator ci = ca.iterator(); ci.hasNext();) {
        int address = ci.next();
        int op = ci.byteAt(address);

        String params = "";
        switch (op) {
            case Opcode.INVOKEINTERFACE:
                int a1 = ci.s16bitAt(address + 1);
                params += " " + cf.getConstPool().getInterfaceMethodrefName(a1);
                System.out.println("a1 = " + a1);
                break;
        }

        System.out.printf("Line %4d. Address %7d: %s%s%n", minfo.getLineNumber(address), address, Mnemonic.OPCODE[op], params);
    }

    // Command line tool of javassist:
    String pathToClass = System.getProperty("user.dir") + "/target/classes/jeggen/test2/MyData.class";
    Dump.main(new String[] { pathToClass });
}