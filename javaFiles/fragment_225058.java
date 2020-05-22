import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class Example {
    private static final int POOL_SIZE = 5;
    private static final ExecutorService WORKERS = new ThreadPoolExecutor(POOL_SIZE, POOL_SIZE, 1, MILLISECONDS, new LinkedBlockingDeque<>());

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String cmd = sc.nextLine();
            switch (cmd) {
                case "process":
                    WORKERS.submit(newExpensiveTask());
                    break;

                case "kill":
                    System.exit(0);

                default:
                    System.err.println("Unrecognized command: " + cmd);
            }
        }
    }

    private static Runnable newExpensiveTask() {
        return () -> {
            try {
                Thread.sleep(10000);
                System.out.println("Done processing");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
    }
}