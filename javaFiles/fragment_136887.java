public class NumberGame {
    public static void main(String[] args) {

        PrintSequenceRunnable.startFrom("T1");

        new Thread(new PrintSequenceRunnable("T1", "T2")).start();
        new Thread(new PrintSequenceRunnable("T2", "T3")).start();
        new Thread(new PrintSequenceRunnable("T3", "T1")).start();
    }
}

class PrintSequenceRunnable implements Runnable {

    private final String name;
    private final String next;

    private static String moveTo;

    private static int value = 1;

    PrintSequenceRunnable(String name, String next) {
        this.name = name;
        this.next = next;
    }

    static void startFrom(String start) {
        moveTo = start;
    }

    private int uselessCounter = 0;

    @Override
    public void run() {
        do {
            synchronized (moveTo) {
                if (name.equals(moveTo)) {
                    System.out.println(name + "-" + (value++));
                    moveTo = next;
                } else {
                    uselessCounter++;
                }
            }
        } while (value < 10);
        System.out.println("Ran " + name + " uselessly for " + uselessCounter + " times."); // remove it.
    }

}