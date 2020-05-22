package fi.schafer.agent;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

public class LoggingAgent {

    public static void premain(String agentArgument, Instrumentation instrumentation) throws Exception {
        instrumentation.addTransformer(new ClassFileTransformer() {
            @Override
            public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
                return doClass(className, classBeingRedefined, classfileBuffer);
            }
        });
    }

    /**
     * Method enhances calls to Thread.sleep with logging.
     */
    private static byte[] doClass(String name, Class clazz, byte[] b) {
        ClassPool pool = ClassPool.getDefault();
        CtClass cl = null;
        try {
            cl = pool.makeClass(new java.io.ByteArrayInputStream(b));
            final CtMethod[] targetMethods = cl.getDeclaredMethods();
            for (CtMethod targetMethod : targetMethods) {
                targetMethod.instrument(new ExprEditor() {
                    public void edit(final MethodCall m) throws CannotCompileException {
                        if ("java.lang.Thread".equals(m.getClassName()) && "sleep".equals(m.getMethodName())) {
                            m.replace("{long startMs = System.currentTimeMillis(); " +
                                    "$_ = $proceed($$); " +
                                    "long endMs = System.currentTimeMillis();" +
                                    "System.out.println(\"Logging Thread.sleep call execution, ms: \" + (endMs-startMs));}");
                        }
                    }
                });
                return cl.toBytecode();
            }
        } catch (Exception e) {
            System.err.println("Could not instrument  " + name
                    + ",  exception : " + e.getMessage());
        } finally {
            if (cl != null) {
                cl.detach();
            }
        }
        return b;
    }

}