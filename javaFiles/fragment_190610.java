private static final MutableCallSite callSite = new MutableCallSite(
        MethodType.methodType(int.class, int.class, int.class));
private static final MethodHandle invoker = callSite.dynamicInvoker();

public MethodHandle mh;

public MyBenchmark() {
    mh = ...;
    callSite.setTarget(mh);
}

@Benchmark
public int boundMethodHandle() throws Throwable {
    return (int) invoker.invokeExact(first, second);
}