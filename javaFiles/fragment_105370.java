private static class ClassAdapter extends ClassVisitor {
    public ClassAdapter(ClassVisitor cv) {
        super(Opcodes.ASM5, cv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc,
            String signature, String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        if (name.equals("targetMethod"))
            return new MethodAdapter(access, name, desc, signature, exceptions, mv);
        else
            return mv;
    }
}

private static class MethodAdapter extends MethodNode {
    public MethodAdapter(int access, String name, String desc,
            String signature, String[] exceptions, MethodVisitor mv) {
        super(Opcodes.ASM5, access, name, desc, signature, exceptions);
        this.mv = mv;
    }
    // More to come ...
}