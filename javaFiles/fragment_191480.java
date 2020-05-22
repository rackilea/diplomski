package bookmarks;

public class A implements Runnable {
    String name;
    static Integer j = 0;
    private static Object lock = new Object();

    A(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 1000; i++) {
            synchronized (lock) {
                A.j++;
            }
        }
        System.out.println(j);

    }

}