import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TwoThreadsOneFileExample {

    public static void main(String[] args) throws InterruptedException {

        Process p1 = new Process("1");
        Thread t1 = new Thread(p1);

        Process p2 = new Process("2");
        Thread t2 = new Thread(p2);

        t1.start();
        Thread.sleep(2000);
        t2.start();

        Thread.sleep(20000);


    }
}

class Process implements Runnable {


    String name;

    public Process(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            processFile();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private void processFile() throws InterruptedException {

        String fileName = "/tmp/test1.txt";

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            System.out.println("process " + name + " opened file");
            stream.forEach(System.out::println);
            Thread.sleep(10000);

        } catch (IOException e){
            throw new RuntimeException(e);
        }
        System.out.println("process " + name + " closed file");

    }
}