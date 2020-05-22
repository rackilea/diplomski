public class Main {
    public static void main(String[] args) {
        example();
    }

    public static void example() {
        B b = new B();
        b.methodB();
    }
}

class B {
    public void methodB(){
        System.out.println("I am methodB");
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StackTraceElement element = stackTrace[2];
        System.out.println("I was called by a method named: " + element.getMethodName());
        System.out.println("That method is in class: " + element.getClassName());
    }
}