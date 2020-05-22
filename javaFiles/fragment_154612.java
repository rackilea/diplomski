CtClass origClazz = ClassPool.getDefault().get("org.example.MyObject");
CtClass subClass = ClassPool.getDefault().makeClass(cls.getName() + "New", origClazz);
CtMethod m = CtNewMethod.make(
             "public void setBar(String bar) { this.bar = bar; }",
             subClass );
subClass .addMethod(m);
Class clazz = cc.toClass();