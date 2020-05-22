package com.adarshr;

import com.thoughtworks.xstream.XStream;


class Parent {
    private String name;
    private int age;

    public Parent(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Test {
    private Parent parent = new Parent("Abcd", 30);

    public static void main(String[] args) throws Exception {
        System.out.println(new Test());
    }

    @Override
    public String toString() {
        return new XStream().toXML(this);
    }
}