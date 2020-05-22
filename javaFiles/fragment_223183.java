package de.scrum_master.app;

public class Application {
    private static void doSomething() {
        System.out.println("Doing something");
    }

    private static String doSomethingElse(String text) {
        System.out.println("Doing something else");
        return text;
    }

    private static int doAnotherThing(int i, int j, int k) {
        System.out.println("Doing another thing");
        return (i + j) * k;
    }

    public static void main(String[] args) {
        doSomething();
        doSomethingElse("foo");
        doAnotherThing(11, 22, 33);
    }
}