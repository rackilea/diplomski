package com.software7.test;

public class Main {
    private native String connect0() ;

    public static void main(String[] args) {
        Main m = new Main();
        m.makeTest(args);
    }

    private void makeTest(String[] args) {
        System.out.println("Java: main called");
        for (String arg : args) {
            System.out.println(" -> Java: argument: '" + arg + "'");
        }
        String res = connect0(); //callback into native code
        System.out.println("Java: result of connect0() is '" + res + "'"); //process returned String
    }
}