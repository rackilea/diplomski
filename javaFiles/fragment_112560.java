package com.test;

public class Test {
    static String s = "";
}

class NotInner {
    public static void main(String[] args) {
        System.out.println(s); //Compilation error: s cannot be resolved to a variable
    }
}