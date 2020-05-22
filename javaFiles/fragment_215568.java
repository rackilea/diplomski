import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class Loader {

    public static ClassReader fetchReader(String binaryName) throws Exception {
        return new ClassReader(
                Loader.class.getClassLoader().getSystemResourceAsStream(
                    binaryName.replace('.', '/') + ".class"
                )
            )
        ;
    }

    public static synchronized Class<?> loadClass(byte[] bytecode)
                throws Exception {
        ClassLoader scl = ClassLoader.getSystemClassLoader();
        Class<?>[] types = new Class<?>[] {
                String.class, byte[].class, int.class, int.class
        };
        Object[] args = new Object[] {
                null, bytecode, 0, bytecode.length
        };
        Method m = ClassLoader.class.getMethod("defineClass", types);
        m.setAccessible(true);
        return (Class<?>) m.invoke(scl, args);
    }

    public static void instrumentTmcore(String[] args) throws Exception {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        MethodReplacer mr = new MethodReplacer(cw, "Test",
                    "(Ljava/lang/String;ZLjava/lang/String;)Z");
        fetchReader("tmcore.objwin").accept(mr, ClassReader.EXPAND_FRAMES);
        loadClass(cw.toByteArray());
        Class.forName("tmcore.game")
            .getMethod("main", new Class<?>[] {args.getClass()})
            .invoke(null, new Object[] { args });
    }
}