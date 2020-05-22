import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(
                   Runtime.getRuntime().availableProcessors() + 1);

        for (int a = 0; a < 30000000; a++) {
            for (int b = 0; b < 30000000; b++) {
                for (int c = 0; c < 30000000; c++) {
                    final int a_copy = a;
                    final int b_copy = b;
                    final int c_copy = c;
                    service.execute(() -> {
                            slowMethod(a_copy, b_copy, c_copy);
                    });
                }
            }
        }
    }

    public static void slowMethod(int a, int b, int c) {

    }
}