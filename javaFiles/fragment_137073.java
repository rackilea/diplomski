static {
    try {
        NativeLoader.loadLibrary("my-lib")
    } catch (IOException ex) {
        throw new ExceptionInInitializerError(ex);
    }
}