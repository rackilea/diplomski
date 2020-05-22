class a implements Runnable {
    Thread thr;
    int count;
    static String time = "Tock";

    a(String s) {
        thr = new Thread(this, s);
        thr.start();
    }

    public void run() {
        count++;

        if (Thread.currentThread().getName().compareTo("one") == 0) {
            synchronized (a.class) {

                try {
                    for (int i = 0; i < 5; i++) {
                        while (time.equals("Tock")) {
                            a.class.wait();
                        }

                        System.out.println("Now running thread "
                                + Thread.currentThread().getName()
                                + " with count " + count);

                        time = "Tock";
                        System.out.println(time);
                        a.class.notify();                       
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        } else if (Thread.currentThread().getName().compareTo("two") == 0) {
            synchronized (a.class) {
                try {
                    for (int j = 0; j < 5; j++) {
                        while (time.equals("Tick")) {
                            a.class.wait();
                        }

                        System.out.println("Now running thread "
                                + Thread.currentThread().getName()
                                + " with count " + count);

                        time = "Tick";
                        System.out.println(time);
                        a.class.notify();                       
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

public class Test {
    public static void main(String args[]) {

        a obj1 = new a("one");
        a obj2 = new a("two");
    }
}