public class ProductorConsumidor {

/**
 * @param args
 *            the command line arguments
 */

static ArrayList<String> buffer = new ArrayList<>();
static Object sync = new Object();
static volatile Boolean isEmpty = false;
static ArrayList<String> chars = new ArrayList<>();

final static int CAPACITY = 3;

private static class productorT extends Thread {
    String phraseS;
    String[] phraseArray;

    public productorT(String phrase) {
        this.phraseS = phrase;
        this.phraseArray = phraseS.split("");
        for (String e : phraseArray) {
            chars.add(e);
        }
    }

    public void run() {
        boolean isStopped = false;
        while (!isEmpty && !isStopped) {
            for (int i = 0; i < CAPACITY && !chars.isEmpty(); i++) {
                System.out.println("> Writing " + chars.get(0));
                buffer.add(chars.get(0));
                chars.remove(0);
            }
            isEmpty = chars.isEmpty();
            synchronized (sync) {
                sync.notifyAll();
                try {
                    sync.wait();
                } catch (InterruptedException e) {
                    System.out.println("Producer has been requested to stop");
                    isStopped = true;
                }
            }
            System.out.println("Remaining="+chars);
        }
        System.out.println("Producer thread has completed writing data");
    }
}

private static class consumerT extends Thread {

    public void run() {
        synchronized (sync) {
            boolean isStopped = false;
            while (!isEmpty && !isStopped) {
                try {
                    System.out.println("Consumer is waiting for more data");
                    sync.wait();
                    for (int i = 0; i < buffer.size(); i++) {
                        System.out.println("< Reading " + buffer.get(i) + " ");
                    }
                    buffer.clear();
                    System.out.println("Consumer thread has completed reading data");
                    sync.notify();
                } catch (InterruptedException e) {
                    System.out.println("The thread has been request to stop");
                    isStopped = true;
                }
            }
        }
    }
}

public static void main(String[] args) {
    final String messageToWrite = "This text is to small to explain a concept clearly";
    Thread productorT = new productorT(messageToWrite);
    Thread consumerT = new consumerT();

    consumerT.start();
    productorT.start();

    try {
        productorT.join();
        consumerT.join();
    } catch (InterruptedException e) {
        System.out.println(e);
    }
}

}