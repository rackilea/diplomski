package de.scrum_master.app;

public class Application {
    public static void main(String[] args) {
        System.out.println(bar(foo()));
    }

    public static String bar(String text) {
        return text + "bar";
    }

    private static String foo() {
        return "foo";
    }
}