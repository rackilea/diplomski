package com.sotest.globalkeylistener;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

public class App 
{
    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new GlobalKeyListener());
    }
}