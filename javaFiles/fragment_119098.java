mv.visitFieldInsn(
    Opcodes.GETSTATIC,
    "java/lang/System",
    "out",
    Type.getObjectType("java/io/PrintStream").getDescriptor()
  );