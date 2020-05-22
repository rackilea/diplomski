ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
String name = "com.test.Sub";
cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,
         name.replace('.', '/'), null, "java/lang/Object", null);
Method ctor = Method.getMethod("void <init>()");
MethodVisitor direct = cw.visitMethod(
         Opcodes.ACC_PUBLIC, ctor.getName(), ctor.getDescriptor(), null, null);
GeneratorAdapter mg = new GeneratorAdapter(Opcodes.ACC_PUBLIC, ctor, direct);
mg.visitCode();
mg.loadThis();
mg.invokeConstructor(Type.getType(Object.class), ctor);
int var = mg.newLocal(Type.DOUBLE_TYPE);
mg.push(42.42);
mg.storeLocal(var);
Label varLabel = mg.mark();
mg.returnValue();
Label endLabel = mg.mark();
direct.visitLocalVariable("x", "D", null, varLabel, endLabel, var);
mg.endMethod();
cw.visitEnd();
byte[] bytes = cw.toByteArray();
Files.write(Paths.get(name + ".class"), bytes);