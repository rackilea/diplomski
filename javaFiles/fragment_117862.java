public class Parent {
    public void generateClass() {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        String superType = Type.getInternalName(Child.class);
        cw.visit(49, Opcodes.ACC_PUBLIC, "Parent$OtherChild", null, superType, null);
        MethodVisitor mv = cw.visitMethod(0, "<init>", "()V", null, null);
        mv.visitVarInsn(Opcodes.ALOAD, 0);
        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, superType, "<init>", "()V", false);
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(-1, -1);
        mv.visitEnd();
        // etc
        byte[] bytes = cw.toByteArray();
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        try {
            Class<?> genClass = lookup.defineClass(bytes);
            Child ch = (Child)
                lookup.findConstructor(genClass, MethodType.methodType(void.class))
                      .invoke();
            System.out.println(ch);
        } catch(Throwable ex) {
            Logger.getLogger(Parent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static class Child {
        Child() {}
    }
}