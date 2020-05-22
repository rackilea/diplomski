public static void main(String[] args) throws Exception {
    ClassPool pool = ClassPool.getDefault();
    CtClass c = pool.get("test.Test");
    CtMethod m = c.getDeclaredMethod("main");
    MethodInfo methodInfo = m.getMethodInfo();
    LocalVariableAttribute t = (LocalVariableAttribute) methodInfo.getCodeAttribute().getAttribute(javassist.bytecode.LocalVariableAttribute.tag);
    int i = t.nameIndex(0); 
    String v = methodInfo.getConstPool().getUtf8Info(i);
    System.out.println(v); 
}