public final static long usedMemory()
{
    return Runtime.getRuntime().totalMemory() 
               - Runtime.getRuntime().freeMemory();
}

public static void main(String[] args) throws Exception
{
    // we get the default ctor
    Constructor<?> ctor = ReflectionFactory
            .getReflectionFactory()
            .newConstructorForSerialization(
                    Main.class, Object.class.getDeclaredConstructor());
    // warm up newInstance
    Object d = ctor.newInstance();
    // warm up Runtime
    System.out.println(usedMemory());
    // warm up Main
    Object b = new Main();
    // force GC
    System.gc();
    // get currently used memory
    final long mem = usedMemory();
    Object a = new Main();
    System.out.println(usedMemory() - mem);
    Object c = ctor.newInstance();
    System.gc();
    System.out.println(usedMemory() - mem);
    System.out.println(a + ", " + b + ", " + c + ", " + d);
}