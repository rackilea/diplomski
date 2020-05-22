package de.scrum_master.app;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(bar(foo()));
            }
        }).start();
        Thread.sleep(200);
    }

    public static String bar(String text) {
        return text + "bar";
    }

    private static String foo() {
        return "foo";
    }
}