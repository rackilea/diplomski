static {
    String dataModel = System.getProperty("sun.arch.data.model");
    String osName = System.getProperty("os.name").toLowerCase();;

    StringBuilder lib = new StringBuilder("/jni/");

    if (osName.contains("win"))
        lib.append("win/");
    else if (osName.contains("linux"))
        lib.append("linux/");
    else if (osName.contains("mac"))
        lib.append("mac/");
    else
        throw new UnsatisfiedLinkError("Loading JD2XX JNI: Unsupported operating system ("+osName+")");

    if (dataModel.equals("32"))
        lib.append("x86_32/");
    else if (dataModel.equals("64"))
        lib.append("x86_64/");
    else
        throw new UnsatisfiedLinkError("Loading JD2XX JNI: Unknown runtime data model ("+dataModel+")");

    if (osName.contains("win"))
        lib.append("jd2xx.dll");
    else if (osName.contains("linux"))
        lib.append("libjd2xx.so");
    else if (osName.contains("mac"))
        lib.append("libjd2xx.jnilib");

    try {
        NativeUtils.loadLibraryFromJar(lib.toString());
    } catch (IOException e) {
        throw new UnsatisfiedLinkError(e.getMessage());
    }
}