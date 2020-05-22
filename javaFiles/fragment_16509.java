public static void main(String[] args) throws Throwable {
    IntToLongFunction i2l = (IntToLongFunction) getKlass().newInstance();
    System.out.println(i2l.applyAsLong(10));
}
public static Class<?> getKlass(){
    String className = "HelloClass";
    ClassWriter classWriter = new ClassWriter(0);
    classWriter.visit(V1_8, ACC_PUBLIC, className, null, getInternalName(Object.class),
                      new String[] { getInternalName(IntToLongFunction.class) } );
    MethodVisitor defaultCtor=classWriter.visitMethod(ACC_PUBLIC,"<init>","()V",null,null);
    defaultCtor.visitVarInsn(ALOAD, 0);
    defaultCtor.visitMethodInsn(INVOKESPECIAL,
                                getInternalName(Object.class), "<init>", "()V", false);
    defaultCtor.visitInsn(RETURN);
    defaultCtor.visitMaxs(1, 1);
    defaultCtor.visitEnd();
    MethodVisitor applyAsLong = classWriter.visitMethod(
                                    ACC_PUBLIC, "applyAsLong", "(I)J",null,null);
    applyAsLong.visitFieldInsn(GETSTATIC,"java/lang/System","out","Ljava/io/PrintStream;");
    applyAsLong.visitLdcInsn("hello generated code"); // stack [PrintStream,String]
    applyAsLong.visitMethodInsn(INVOKEVIRTUAL,
                    "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
    applyAsLong.visitVarInsn(ILOAD, 1); // stack [int]
    applyAsLong.visitInsn(I2L); // stack [long,*]
    applyAsLong.visitInsn(LRETURN);
    applyAsLong.visitMaxs(2, 2);// max stack see above, vars: [this,arg1:int]
    applyAsLong.visitEnd();
    return new ByteArrayClassLoader().defineClass(classWriter.toByteArray());
}