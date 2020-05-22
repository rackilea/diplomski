ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
  cw.visit...

  byte[] byteArray = cw.toByteArray();
  ClassReader cr = new ClassReader(byteArray);
  cr.accept(new CheckClassAdapter(new ClassWriter(0)), 0);