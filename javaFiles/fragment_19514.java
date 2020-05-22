package com.stackoverflow.questions52609313.client;

import jsinterop.annotations.JsIgnore;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

@JsType(namespace = JsPackage.GLOBAL)
public class MyJsClass {
    @JsProperty
    private String value;
    @JsIgnore
    private int callCounter = 0;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    public String myMethod() {
        callCounter++;
        return "ok";
    }

    public int getCallCounter() {
        return callCounter;
    }
}