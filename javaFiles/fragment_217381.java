import java.util.concurrent.atomic.AtomicBoolean;

public class Student extends Thread {

    // note the static: there is only one bathroom for all students
    private static AtomicBoolean occupied = new AtomicBoolean(false);

    private String name;

    public Student(String name) {
        this.name = name;
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println(name + " wet his/her pants");
        }
    }

    @Override
    public void run() {
        int r = (int)(Math.random() * 5000);
        System.out.println(name + " sleeps for " + r + " ms");
        sleep(r);
        System.out.println(name + " goes to bathroom");
        // ***** busy wait *****
        while (!occupied.compareAndSet(false, true)) {
            System.out.println(name + " takes a break");
            Thread.yield();
            sleep(1000);
        }
        // ***** end (in bathroom) *****
        System.out.println(name + " is in the bathroom");
        sleep(1000);
        occupied.set(false);
        System.out.println(name + " goes to university");
    }

    public static void main(String[] args) {
        new Student("Bob").start();
        new Student("Alice").start();
        new Student("Peter").start();
        new Student("Marcia").start();
        new Student("Desmond").start();
        new Student("Sophia").start();
    }

}