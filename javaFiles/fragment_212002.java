public class GetSignatureDemo {

    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("/tmp/GetSignature.class");
        ClassReader classReader = new ClassReader(is);
        classReader.accept(getClassVisitor(), 0);
    }

    private static ClassVisitor getClassVisitor() {
        return new ClassVisitor(Opcodes.ASM4) {
            @Override
            public MethodVisitor visitMethod(int access, String name,
                    String descriptor, String signature, String[] exceptions) {
                System.out.printf(
                        "method: %s  descriptor: %s  signature: %s%n",
                        name,
                        descriptor,
                        signature
                );
                return super.visitMethod(access, name, descriptor, signature, exceptions);
            }
        };
    }
}