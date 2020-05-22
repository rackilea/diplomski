public class YourClassVisitor extends ClassVisitor {
    public YourClassVisitor(ClassVisitor cv) {
        super(Opcodes.ASM5, cv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if (name.equals("targetName")) {
            return new YourMethodVisitor(super.visitMethod(access, name, desc, signature, exceptions));
        }
        return super.visitMethod(access, name, desc, signature, exceptions);
    }


    private static class YourMethodVisitor extends MethodVisitor {
        public YourMethodVisitor(MethodVisitor mv) {
            super(Opcodes.ASM5, mv);
        }

        // This method will be called before almost all instructions
        @Override
        public void visitCode() {
            // Default implementation is empty. So we haven't to call super method

            // Puts 'this' on top of the stack. If your method is static just delete it
            visitVarInsn(Opcodes.ALOAD, 0);
            // Takes instance of class "the/full/name/of/your/Class" from top of the stack and put value of field interceptors
            // "Ljava/util/List;" is just internal name of java.util.List
            // If your field is static just replace GETFIELD with GETSTATIC
            visitFieldInsn(Opcodes.GETFIELD, "the/full/name/of/your/Class", "interceptors", "Ljava/util/List;");
            // Before we call add method of list we have to put target value on top of the stack
            // New object creation starts with creating not initialized instance of it
            visitTypeInsn(Opcodes.NEW, "com/shehabic/sherlock/interceptors");
            // Than we just copy it
            visitInsn(Opcodes.DUP);
            visitTypeInsn(Opcodes.NEW, "example/path/to/class/SherlockOkHttpInterceptor");
            visitInsn(Opcodes.DUP);
            // We have to call classes constructor
            // Internal name of constructor - <init>
            // ()V - signature of method. () - method doesn't have parameters. V - method returns void
            visitMethodInsn(Opcodes.INVOKESPECIAL, "example/path/to/class/SherlockOkHttpInterceptor", "<init>", "()V", false);
            // So on top of the stack we have initialized instance of example/path/to/class/SherlockOkHttpInterceptor
            // Now we can call constructor of com/shehabic/sherlock/interceptors
            visitMethodInsn(Opcodes.INVOKESPECIAL, "com/shehabic/sherlock/interceptors", "<init>", "(Lexample/path/to/class/SherlockOkHttpInterceptor;)V", false);
            // So on top of the stack we have initialized instance of com/shehabic/sherlock/interceptors
            // Now we can put it into list
            visitMethodInsn(Opcodes.INVOKEINTERFACE, "java/util/List", "add", "(Ljava/lang/Object;)Z", true);



        }
    }

}