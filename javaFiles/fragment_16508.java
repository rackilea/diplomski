String className = "HelloClass";
ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
classWriter.visit(V1_8, ACC_PUBLIC, className, null,
    getInternalName(Object.class), new String[]{getInternalName(IntToLongFunction.class)});
MethodVisitor defaultCtor = classWriter.visitMethod(ACC_PUBLIC, "<init>", "()V",null,null);
defaultCtor.visitVarInsn(ALOAD, 0);
defaultCtor.visitMethodInsn(INVOKESPECIAL,
                            getInternalName(Object.class), "<init>", "()V", false);
defaultCtor.visitInsn(RETURN);
defaultCtor.visitMaxs(-1, -1);
defaultCtor.visitEnd();
return new ByteArrayClassLoader().defineClass(classWriter.toByteArray());