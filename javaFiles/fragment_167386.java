package com.python27;
class Python {
static {
    System.loadLibrary("python2.7");
}

public static native void Initialize();
public static native void Finalize();
public static native int Run(String s);
}