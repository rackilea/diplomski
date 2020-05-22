public byte[] transform(ClassLoader loader, String className, Class<?> cl,
                        ProtectionDomain pd, byte[] classfileBuffer) {
    if(!TRANSFORM_CLASS.equals(className)) return null;

    ClassReader cr = new ClassReader(classfileBuffer);
    ClassWriter cw = new ClassWriter(cr, 0);
    cr.accept(new ClassVisitor(Opcodes.ASM5, cw) {
        @Override
        public FieldVisitor visitField(int access, String name, String desc,
                                       String signature, Object cst) {
            if("Hello World".equals(cst)) cst = "Multiply Of x*y is: ";
            return super.visitField(access, name, desc, signature, cst);
        }

        @Override
        public MethodVisitor visitMethod(int access, String name, String desc,
                                         String signature, String[] exceptions) {
            MethodVisitor mv = super.visitMethod(
                                   access, name, desc, signature, exceptions);
            if(name.equals(TRANSFORM_METHOD_NAME)
            && desc.equals(TRANSFORM_METHOD_DESC)) {
                return new MethodVisitor(Opcodes.ASM5, mv) {
                    @Override
                    public void visitLdcInsn(Object cst) {
                        if("Hello World".equals(cst)) cst = "Multiply Of x*y is: ";
                        super.visitLdcInsn(cst);
                    }
                };
            }
            return mv;
        }
    }, 0);
    return cw.toByteArray();
}