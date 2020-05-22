package com.example.stackoverflow;

import javax.persistence.NoResultException;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
        System.out.println(app.valueReturningMethod(1, "two"));
        System.out.println(app.exceptionThrowingMethod(1, "two"));
    }

    public Object valueReturningMethod(int i, String string) {
        return "normal result";
    }

    public Object exceptionThrowingMethod(int i, String string) {
        throw new NoResultException();
    }
}