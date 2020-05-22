import java.io.File;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import java.io.FileOutputStream;
import java.io.IOException;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.util.CheckClassAdapter;
import static org.objectweb.asm.Opcodes.*;

public class App {
    public static void main(String[] args) throws IOException {
        ClassWriter cw = new ClassWriter(0);
        CheckClassAdapter ca = new CheckClassAdapter(cw);
        ca.visit(V1_5, ACC_PUBLIC + ACC_SUPER, "test/Test", null, "java/lang/Object", null);
        ca.visitSource("this/file/does/not/exist.txt", null); // Not sure what the second parameter does
        MethodVisitor mv = ca.visitMethod(ACC_PUBLIC | ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);

        mv.visitCode();
        Label label = new Label();
        mv.visitLabel(label);
        mv.visitLineNumber(123, label);
        mv.visitTypeInsn(NEW, "java/lang/RuntimeException");
        mv.visitInsn(DUP);
        mv.visitMethodInsn(INVOKESPECIAL, "java/lang/RuntimeException", "<init>", "()V");
        mv.visitInsn(ATHROW);
        mv.visitInsn(RETURN);
        mv.visitMaxs(2, 1);
        mv.visitEnd();

        ca.visitEnd();

        File target = new File("target/classes/test/");
        target.mkdirs();
        FileOutputStream out = new FileOutputStream(new File(target, "Test.class"));
        out.write(cw.toByteArray());
        out.close();
    }
}