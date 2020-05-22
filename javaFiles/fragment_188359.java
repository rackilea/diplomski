package com;
public class A {
    private B b;

    public A() {
        b = new B();
    }

    public static void main(String... args) {
        (new A()).print();
    }

    public void print() {
        System.out.println(b.getText());
    }
}