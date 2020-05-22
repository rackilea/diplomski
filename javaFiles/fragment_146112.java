try {
    Class.forName("MyClass");
} catch(ClassNotFoundException e) {
    ClassPool pool = ClassPool.getDefault();
    CtClass cc = pool.makeClass("MyClass");
    cc.toClass(this.getClass().getClassLoader(), this.getClass().getProtectionDomain());
    Class.forName("MyClass");
}