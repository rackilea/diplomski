ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
String name = "com.test.Sub";
String superClName = "java/lang/Object", ctorName = "<init>", ctorDesc = "()V";
cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, name.replace('.','/'), null, superClName, null);
MethodVisitor direct = cw.visitMethod(Opcodes.ACC_PUBLIC, ctorName, ctorDesc, null, null);
direct.visitCode();
// "this" is alway 0 (zero) and for parameterless methods the next var location is 1 (one)
int thisVar = 0, var = 1;
direct.visitVarInsn(Opcodes.ALOAD, thisVar);
direct.visitMethodInsn(Opcodes.INVOKESPECIAL, superClName, ctorName, ctorDesc, false);
direct.visitLdcInsn(42.42);
Label varLabel = new Label(), endLabel = new Label();
direct.visitVarInsn(Opcodes.DSTORE, var);
direct.visitLabel(varLabel);
direct.visitInsn(Opcodes.RETURN);
direct.visitLabel(endLabel);
direct.visitLocalVariable("x", "D", null, varLabel, endLabel, var);
direct.visitMaxs(-1, -1);// no actual values, using COMPUTE_FRAMES
direct.visitEnd();
cw.visitEnd();
byte[] bytes = cw.toByteArray();
Files.write(Paths.get(name + ".class"), bytes);