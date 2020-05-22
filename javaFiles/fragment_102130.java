classReader.accept(new ClassVisitor(Opcodes.ASM7) {
    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor,
                                     String signature, String[] exceptions) {
        MethodVisitor actualVisitor = new MethodVisitor(Opcodes.ASM7) {
            @Override
            public void visitInsn(int opcode) {
                System.out.printf("%02x%n", opcode);
            }

            @Override
            public void visitMaxs(int maxStack, int maxLocals) {
                System.out.println("max stack: "+maxStack);
            }
        };
        return new MethodNode(Opcodes.ASM7) {
            @Override
            public void visitMaxs(int maxStack, int maxLocals) {
                actualVisitor.visitMaxs(maxStack, maxLocals);
                super.visitMaxs(maxStack, maxLocals);
            }
            @Override
            public void visitEnd() {
                accept(actualVisitor);
            }
        };
    }
}, 0);