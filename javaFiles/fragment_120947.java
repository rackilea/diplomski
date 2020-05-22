package de.test;

import java.lang.reflect.Constructor;

public class Base {

    private Base instance;

    private Base() {
    }

    public static class BaseHelper {
        Base instance = new Base();
    }

    public static void main(String[] args) {
        Constructor[] constructors = Base.class.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor + " - synthetic? " + constructor.isSynthetic());
        }
    }
}