package asm.bytecodetests;
import java.util.*;
import org.objectweb.asm.*;
public class BytecodeTestsDump implements Opcodes {

public static byte[] dump () throws Exception {

ClassWriter cw = new ClassWriter(0);
FieldVisitor fv;
MethodVisitor mv;
AnnotationVisitor av0;

cw.visit(52, ACC_PUBLIC + ACC_SUPER, "bytecodetests/BytecodeTests", null, "java/lang/Object", null);

cw.visitSource("BytecodeTests.java", null);

{
mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
mv.visitCode();
Label l0 = new Label();
mv.visitLabel(l0);
mv.visitLineNumber(9, l0);
mv.visitVarInsn(ALOAD, 0);
mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
mv.visitInsn(RETURN);
Label l1 = new Label();
mv.visitLabel(l1);
mv.visitLocalVariable("this", "Lbytecodetests/BytecodeTests;", null, l0, l1, 0);
mv.visitMaxs(1, 1);
mv.visitEnd();
}
{
mv = cw.visitMethod(ACC_PUBLIC + ACC_STATIC, "main", "([Ljava/lang/String;)V", null, new String[] { "java/io/IOException" });
mv.visitCode();
Label l0 = new Label();
mv.visitLabel(l0);
mv.visitLineNumber(12, l0);
mv.visitTypeInsn(NEW, "org/objectweb/asm/ClassReader");
mv.visitInsn(DUP);
mv.visitLdcInsn(Type.getType("Lbytecodetests/BytecodeTests;"));
mv.visitLdcInsn("BytecodeTests.class");
mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Class", "getResourceAsStream", "(Ljava/lang/String;)Ljava/io/InputStream;", false);
mv.visitMethodInsn(INVOKESPECIAL, "org/objectweb/asm/ClassReader", "<init>", "(Ljava/io/InputStream;)V", false);
mv.visitTypeInsn(NEW, "org/objectweb/asm/util/TraceClassVisitor");
mv.visitInsn(DUP);
mv.visitInsn(ACONST_NULL);
mv.visitTypeInsn(NEW, "org/objectweb/asm/util/ASMifier");
mv.visitInsn(DUP);
mv.visitMethodInsn(INVOKESPECIAL, "org/objectweb/asm/util/ASMifier", "<init>", "()V", false);
mv.visitTypeInsn(NEW, "java/io/PrintWriter");
mv.visitInsn(DUP);
mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
mv.visitMethodInsn(INVOKESPECIAL, "java/io/PrintWriter", "<init>", "(Ljava/io/OutputStream;)V", false);
mv.visitMethodInsn(INVOKESPECIAL, "org/objectweb/asm/util/TraceClassVisitor", "<init>", "(Lorg/objectweb/asm/ClassVisitor;Lorg/objectweb/asm/util/Printer;Ljava/io/PrintWriter;)V", false);
mv.visitInsn(ICONST_0);
Label l1 = new Label();
mv.visitLabel(l1);
mv.visitLineNumber(13, l1);
mv.visitMethodInsn(INVOKEVIRTUAL, "org/objectweb/asm/ClassReader", "accept", "(Lorg/objectweb/asm/ClassVisitor;I)V", false);
Label l2 = new Label();
mv.visitLabel(l2);
mv.visitLineNumber(14, l2);
mv.visitInsn(RETURN);
Label l3 = new Label();
mv.visitLabel(l3);
mv.visitLocalVariable("args", "[Ljava/lang/String;", null, l0, l3, 0);
mv.visitMaxs(8, 1);
mv.visitEnd();
}
cw.visitEnd();

return cw.toByteArray();
}
}