public class ReturnAdapter extends ClassVisitor {
  private String className;

  public ReturnAdapter(ClassVisitor cv, String className) {
    super(Opcodes.ASM4, cv);
  }

  @Override
  public MethodVisitor visitMethod(
    int access,
    String name,
    String desc,
    String signature,
    String[] exceptions) {
    MethodVisitor mv;
    mv = cv.visitMethod(access, name, desc, signature, exceptions);
    mv = new MethodReturnAdapter(Opcodes.ASM4, className, access, name, desc, mv);
    return mv;
  }

  public static void main(String[] args) throws IOException {
    String classFile = args[0];//path of the class file
    String className = args[1];//name of the class
    File inFile = new File(classFile);
    FileInputStream in = new FileInputStream(inFile);

    // adapting the class.
    ClassReader cr = new ClassReader(in);
    ClassWriter cw = new ClassWriter(ClassReader.EXPAND_FRAMES);
    ReturnAdapter returnAdapter = new ReturnAdapter(cw, className);
    cr.accept(returnAdapter, 0);
  }
}

/**
* Method Visitor that inserts code right before its return instruction(s),
* using the onMethodExit(int opcode) method of the AdviceAdapter class,
* from ASM(.ow2.org).
* @author vijay
*
*/
class MethodReturnAdapter extends AdviceAdapter {
  public MethodReturnAdapter(
      int api,
      String owner,
      int access,
      String name,
      String desc,
      MethodVisitor mv) {
    super(Opcodes.ASM4, mv, access, name, desc);
  }

  public MethodReturnAdapter(
      MethodVisitor mv,
      int access,
      String name,
      String desc) {
    super(Opcodes.ASM4, mv, access, name, desc);
  }

  @Override
  protected void onMethodEnter(int opcode) {
      mv.visitVarInsn(ALOAD, 1);
      // and/or any other visit instructions.
  }

  @Override
  protected void onMethodExit(int opcode) {
    if(opcode != Opcodes.ATHROW) {
      mv.visitVarInsn(Opcodes.ALOAD, 1);
      // and/or any other visit instructions.
    }
  }
}