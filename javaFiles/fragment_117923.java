package com.example;
public class Foo {

    public static void main(String[] args) {
        foo(); // non-qualified reference
        Foo.foo(); // qualified reference
        com.example.Foo.foo(); // (full) qualified reference
    }

    static void foo() {}

}