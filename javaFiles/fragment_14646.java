import org.objectweb.asm.*;
import org.objectweb.asm.commons.EmptyVisitor;
import java.io.*;

public class ClinitKiller {
    public static void main (String[] args) {
        final InputStream input = ClinitKiller.class.getResourceAsStream(Test.class.getName() + ".class");
        try {
            final byte[] bytes = instrument(input);
            FileOutputStream out = new FileOutputStream("/tmp/Test.class");
            out.write(bytes);
            out.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] instrument(InputStream is) throws IOException {
        ClassReader reader = new ClassReader(is);
        ClassWriter writer = new ClassWriter(0);
        ClinitKillerClassAdapter classAdapter = new ClinitKillerClassAdapter(writer);
        reader.accept(classAdapter, 0);
        return writer.toByteArray();
    }
}

class ClinitKillerClassAdapter extends ClassAdapter {
    public ClinitKillerClassAdapter(final ClassVisitor cv) {
        super(cv);
    }

    public MethodVisitor visitMethod(final int access, final String name, final String desc, final String signature, final String[] exceptions) {
        if (name.equals("<clinit>")) {
            return new EmptyVisitor();
        }
        return cv.visitMethod(access, name, desc, signature, exceptions);
    }
}