JavaClass target;
try {
  target = Repository.lookupClass("Target");
} catch (final ClassNotFoundException ex) {
  throw new RuntimeException("unable to resolve Target", ex);
}
final ClassGen targetGen = new ClassGen(target);
final ConstantPoolGen pool = targetGen.getConstantPool();
final ConstantMethodref ref = (ConstantMethodref) pool.getConstant(
    pool.lookupMethodref("Name", "getName", "()Ljava/lang/String;"));
ref.setClassIndex(pool.lookupClass("Target"));
ref.setNameAndTypeIndex(pool.addNameAndType("$Name$getName", "()Ljava/lang/String;"));
final InstructionList code = new InstructionList();
final InstructionFactory factory = new InstructionFactory(targetGen, pool);
code.append(factory.createConstant("overriden-name"));
code.append(factory.createReturn(Type.STRING));
code.setPositions();
final MethodGen methodGen = new MethodGen(
    Constants.ACC_PRIVATE | Constants.ACC_SYNTHETIC | Constants.ACC_STATIC,
    Type.STRING, new Type[0], new String[0], "$Name$getName", "Target",
    code, pool);
methodGen.setMaxLocals(0);
methodGen.setMaxStack(1);
targetGen.addMethod(methodGen.getMethod());
try {
  targetGen.getJavaClass().dump("Target.class");
} catch (final IOException ex) {
  throw new RuntimeException("unable to save Target", ex);
}