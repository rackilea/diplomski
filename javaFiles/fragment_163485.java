class MyAdapter extends ClassAdapter {
  public MyAdapter(ClassVisitor delegate) {
    super(delegate);
  }

  @Override
  public MethodVisitor visitMethod(int access, String name, 
                            String desc, String signature, String[] exceptions) {
    MethodVisitor r = super.visitMethod(access, name, desc, signature, exceptions);
    if ("<clinit>".equals(name)) {
      r = new MyMethodAdapter(r);
    }
    return r;
  }

  class MyMethodAdapter extends MethodAdapter {
    MyMethodAdapter(MethodVisitor delegate) {
      super(delegate);
    }

    @Override
    public void visitCode() {
      super.visitCode();
      // build my static initializer by calling
      // visitFieldInsn(int opcode, String owner, String name, String desc) 
      // or the like
    }
  }
}