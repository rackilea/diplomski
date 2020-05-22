import org.objectweb.asm.*;
import java.lang.invoke.*;
import java.lang.reflect.Constructor;

import static org.objectweb.asm.Opcodes.*;

public class InvokeGenerator extends ClassLoader {

    private static Class<?> generate() {
        ClassWriter cv = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cv.visit(V1_7, ACC_PUBLIC, "InvokeImpl", null, "java/lang/Object", null);

        MethodVisitor mv = cv.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
        mv.visitCode();
        mv.visitVarInsn(ALOAD, 0);
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);

        // Generate INVOKEDYNAMIC instead of NEW+INVOKESPECIAL.
        // This will instantiate the target class by calling its private constructor.
        // Bootstrap method is called just once to link this call site.
        mv.visitInvokeDynamicInsn("invoke", "()LInvokeGenerator$Target;",
                new Handle(H_INVOKESTATIC, "InvokeGenerator", "bootstrap", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false));
        // Here we have newly constructed instance of InvokeGenerator.Target
        mv.visitInsn(POP);

        mv.visitInsn(RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();

        cv.visitEnd();
        byte[] classData = cv.toByteArray();

        return new InvokeGenerator().defineClass(null, classData, 0, classData.length);
    }

    public static void main(String[] args) throws Exception {
        Class<?> cls = generate();
        cls.newInstance();
    }

    public static CallSite bootstrap(MethodHandles.Lookup lookup, String name, MethodType type) throws Exception {
        // Derive the constructor signature from the signature of this INVOKEDYNAMIC
        Constructor c = type.returnType().getDeclaredConstructor(type.parameterArray());
        c.setAccessible(true);
        // Convert Constructor to MethodHandle which will serve as a target of INVOKEDYNAMIC
        MethodHandle mh = lookup.unreflectConstructor(c);
        return new ConstantCallSite(mh);
    }

    public static class Target {
        private Target() {
            System.out.println("Private constructor called");
        }
    }
}