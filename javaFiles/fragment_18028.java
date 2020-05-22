public abstract class Super {
    public void run() {
        System.out.println("Method called");
        printMessage();
    }
    abstract void printMessage ();
}

public class Sub1 extends Super {
    @Override
    void printMessage() {
        System.out.println("Sub1 called");
    }
}

public class Sub2 extends Super {
    @Override
    void printMessage () {
        System.out.println("Sub2 called");
    }
}