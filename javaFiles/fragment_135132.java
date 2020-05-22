import java.io.IOException;
import java.util.Optional;
import org.objectweb.asm.*;

public class FindAllReferencedMethods {
    class Example {
        void create() {
            System.out.println("TEST");
            Optional.of("String").map(String::valueOf).get();
        }
    }
    public static void main(String[] args) throws IOException {
        ClassReader r = new ClassReader(Example.class.getName());
        r.accept(new ClassVisitor(Opcodes.ASM5) {
            @Override
            public MethodVisitor visitMethod(
                   int access, String name, String desc, String sig, String[] ex) {
                return name.equals("create")? new MethodRefCollector(): null;
            }

        }, ClassReader.SKIP_DEBUG|ClassReader.SKIP_FRAMES);
    }

    static void referencedMethod(String owner, String name, String desc) {
        System.out.println(
            Type.getObjectType(owner).getClassName() + "." + name + " " + desc);
    }

    static class MethodRefCollector extends MethodVisitor {
        public MethodRefCollector() {
            super(Opcodes.ASM5);
        }

        @Override
        public void visitMethodInsn(
                    int opcode, String owner, String name, String desc, boolean itf) {
            referencedMethod(owner, name, desc);
        }

        @Override
        public void visitInvokeDynamicInsn(
                    String name, String desc, Handle bsm, Object... bsmArgs) {
            if(bsm.getOwner().equals("java/lang/invoke/LambdaMetafactory")
            && bsm.getDesc().equals(bsm.getName().equals("altMetafactory")?
                                    ALT_SIG: MF_SIG)) {
                Handle target = (Handle)bsmArgs[1];
                referencedMethod(target.getOwner(), target.getName(), target.getDesc());
            }
        }
    }
    static String MF_SIG = "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;"
        +"Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/"
        +"MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;";
    static String ALT_SIG = "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;"
        +"Ljava/lang/invoke/MethodType;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;";
}