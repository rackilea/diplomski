protected static StdCallLibrary getLibrary(String libraryName,
        Class<?> interfaceClass) throws UnsatisfiedLinkError {
    try {
        StdCallLibrary lib = (StdCallLibrary) Native.loadLibrary(libraryName,
                interfaceClass);
        return lib;
    } catch (UnsatisfiedLinkError e) {
        Logger.out.error("Could not load " + libraryName + " library.");
        throw e;
    }
}