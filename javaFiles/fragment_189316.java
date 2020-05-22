public static void main(String[] args) throws Exception {
    // Ensure Standard class classloading by creating an instance 
    // (calling a static method like Standard.init() would also do)
    Standard standard = new Standard();
    standard.doSomething();
    ClassPool pool = ClassPool.getDefault();
    CtClass clazz = pool.get("Standard");
    HotSwapper swap = new HotSwapper(8000);
    swap.reload("Standard", clazz.toBytecode());
}