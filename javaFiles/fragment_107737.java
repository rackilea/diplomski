new ClassReader(Foo.class.getName()).accept(new ClassVisitor() {
  @Override
  public MethodVisitor visitMethod(int access, String name, String desc, 
      String signature, String[] exceptions) {
    if(name.equals("compareTo") { // We found a method named 'compareTo'
      return new MethodVisitor() {
        @Override // Callback for byte code method instructions
        public void visitMethodInsn(int opcode, String owner, 
            String name, String desc) {
          System.out.println("Method " + name + " was called on " + owner);
        }
        @Override // Callback for byte code field instructions
        public void visitFieldInsn(int opcode, String owner, 
            String name, String desc) {
          System.out.println("Field " + name + " was accessed on " + owner);
        }
      }
    }
    return null;
  }
}