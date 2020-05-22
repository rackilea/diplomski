package com.example;


public class Example {

    public String exampleString;
    protected int exampleInt;
    private float exampleFloat;
    private String excludedString;
    static String staticString;

    @Override
    public String toString() {
        return ((((((((("Example ["+"exampleString = ")+ exampleString)+", ")+"exampleInt = ")+ exampleInt)+", ")+"exampleFloat = ")+ exampleFloat)+"]");
    }

}