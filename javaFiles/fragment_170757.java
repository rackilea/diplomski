public class Sub implements ILogger<Sub> {

    static {
        ILogger.classMap.put(Sub.class, /* ... value ... */);
    }

    public Sub() {
        Log.debug(LogTag, ...);
    }
}