{
mv = cw.visitMethod(ACC_PUBLIC, "Test",
    "(Ljava/lang/String;ZLjava/lang/String;)Z", null, null);
mv.visitCode();
Label l1 = new Label();
mv.visitLabel(l1);
mv.visitFieldInsn(GETSTATIC, "java/lang/System",
   "out", "Ljava/io/PrintStream;");
mv.visitLdcInsn("GOTit");
mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream",
   "println", "(Ljava/lang/String;)V");
Label l2 = new Label();
mv.visitLabel(l2);
mv.visitInsn(ICONST_0);
mv.visitInsn(IRETURN);
Label l3 = new Label();
mv.visitLabel(l3);
mv.visitLocalVariable("this", "LcheckASM/MethodCall;", null, l1, l3, 0);
mv.visitLocalVariable("a", "Ljava/lang/String;", null, l1, l3, 1);
mv.visitLocalVariable("b", "Z", null, l1, l3, 2);
mv.visitLocalVariable("c", "Ljava/lang/String;", null, l1, l3, 3);
mv.visitMaxs(4, 4);
mv.visitEnd();
}