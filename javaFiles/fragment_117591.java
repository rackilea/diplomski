package de.scrum_master.app;

public class Example {
    @MyAnnotation(id = 11, name = "John", remark = "my best friend")
    public void divideByZeroWithCatch(int dividend, String someText) {
        try {
            int a = 5 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Can not divide by zero");
        }
    }

    public void divideByZeroWithNoCatch() {
        int b = 5 / 0;
    }

    public static void main(String[] args) {
        Example e = new Example();
        System.out.println("***** Calling method with catch block *****");
        e.divideByZeroWithCatch(123, "Hello world!");
        System.out.println("***** Calling method without catch block *****");
        e.divideByZeroWithNoCatch();
    }
}