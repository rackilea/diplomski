public static class BugFixAgent {
  public static void premain(String args, Instrumentation inst) {
    inst.addClassFileTransformer(new ClassFileTransformer() {
      @Override
      public byte[] transform(ClassLoader loader, 
                              String className, 
                              Class<?> classBeingRedefined, 
                              ProtectionDomain protectionDomain, 
                              byte[] classfileBuffer) {
        if (className.equals("javax/swing/plaf/basic/BasicLabelUI")) {
          return patchedClassFile; // as found in the repository
          // Consider removing the transformer for future class loading
        } else {
          return null; // skips instrumentation for other classes
        }
      }
    });
  }
}