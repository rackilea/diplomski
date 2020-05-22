package test;

public class XXX {
    public static void main(String[] args) throws InterruptedException {
        Foo instance = Foo.getInstance();
        Thread x = new Thread(instance);

        for (int count = 1; count < 100000; count++)
            instance.addToQueue(count + "");

        x.start();
        instance.turnOff();
    }
}