package com.example;

class Foo {

    public static void bar() {
        System.out.println("Hello there.");
    }
}

public class ServerApp {

    public static void main(String[] args) throws Exception {
        //read the class and method name from the socket
        String className = "com.example.Foo";
        String methodName = "bar";

        Class<?> clazz = Class.forName(className);
        clazz.getMethod(methodName).invoke(clazz);
    }
}