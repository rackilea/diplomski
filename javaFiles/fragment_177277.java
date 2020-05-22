package com.example.yourname.yourproject;

public class linkToNative {

    public native String compare(long src,long dest);

    static {
        System.loadLibrary("compare");
    }

}