package filevisitor;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ProducerConsumerMain {
    public static void main(String[] args) {
        Path startingDir = Paths.get("src/filevisitor");
        JavaFileVisitor fileVisitor = new JavaFileVisitor();
        ExecutorService executor = Executors.newCachedThreadPool();
        final ProducerConsumer producerConsumer = new ProducerConsumer(startingDir, fileVisitor);

        executor.submit(new Runnable() {
            public void run() {
                System.out.println("Producer started");
                try {
                    producerConsumer.produce();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Producer finished");
            }
        });

        for (int j = 0; j < 5; j++) {
            executor.submit(new Runnable() {
                public void run() {
                    String threadName = Thread.currentThread().getName();
                    System.out.println(threadName + " Consumer Started");
                    try {
                        producerConsumer.consume();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(threadName + " Consumer finished");
                }
            });
        }

        executor.shutdown();
        System.out.println("Executor shutdown, waiting for threads to finish");

        try {
            executor.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exiting main");
    }
}