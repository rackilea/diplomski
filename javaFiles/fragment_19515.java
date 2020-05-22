package com.stackoverflow.questions52609313.client;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

@JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "window")
public class GlobalVariableExtension {
    public static MyJsClass myGlobalVariable;
}