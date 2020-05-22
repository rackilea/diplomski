import java.io.*;
import java.util.concurrent.*;

public class Test {
    static class ReadInput implements Callable<Integer> {

        public Integer call() throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            try {
                while (br.ready() == false) {
                    Thread.sleep(250);
                }

                String input = br.readLine();
                return Integer.parseInt(input);

            } catch (InterruptedException e) {
                return null;
            }
        }
    }

    public static void main(String[] args) {

        Integer input = null;
        ExecutorService ex = Executors.newSingleThreadExecutor();

        try {
            Future<Integer> future = ex.submit(new ReadInput());
            input = future.get(3500, TimeUnit.MILLISECONDS);

        } catch (ExecutionException | InterruptedException | TimeoutException e) {
            // handle exceptions that need to be handeled
        } finally {
            ex.shutdownNow();
        }

        System.out.println("done: " + input);
    }
}