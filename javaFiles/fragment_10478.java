public abstract class CompanyException extends Exception {
    private static final List<ExceptionCallback> callBacks =
            new ArrayList<ExceptionCallback>();

    public CompanyException(String message) {
        super(message);
        invokeCallbacks();
    }

    // register class to be called whenever exception is constructed
    public static void registerCallback(ExceptionCallback callback) {
        // we expect the registers to be done long before the first exception thrown
        List<ExceptionCallback> newCallbacks = new ArrayList<ExceptionCallback>();
        newCallBacks.addAll(callBacks);
        newCallbacks.add(callback);
        callBacks = newCallBacks;
    }

    private void invokeCallbacks() {
        for (ExceptionCallback callBack : callBacks) {
            try {
                callBack.exceptionConstructed(this);
            } catch (Throwable th) {
                // ignore it because we can't go recursive 
            }
        }
    }
}