public MethodVisitor visitMethod(int access ... ... ... ) {
  MethodVisitor mv;
  mv = cv.visitMethod(access, name, desc, signature, exceptions);
  mv = new MethodReturnAdapter(Opcodes.ASM4, className, access, name, desc, mv);
  return mv;
}