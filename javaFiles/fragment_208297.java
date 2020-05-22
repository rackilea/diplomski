import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MultiThreadedLineSearcherExecutor {

    static final int MAX_THREADS = 10;

    public static void main(String[] args) throws Exception {
        // Create as many threads as there are lines of text,
        // but do not exceed 10 threads
        int lineCount = LINES.length;
        int threadPoolSize = Math.min(MAX_THREADS, lineCount);
        System.out.println("Number of lines = " + lineCount);
        System.out.println("Thread pool size = " + threadPoolSize);
        ExecutorService executor = Executors.newFixedThreadPool(threadPoolSize);
        Future previousFuture = null;
        for (int i = 0; i < lineCount; i++) {
            JobRunnable job = new JobRunnable(i, LINES[i], previousFuture);
            previousFuture = executor.submit(job);
        }
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        System.out.println("Program done.");
    }

    public static class JobRunnable implements Runnable {
        private final int _lineIdx;
        private final String _lineText;
        private final Future _futureToWaitForBeforePrinting;

        public JobRunnable(int lineIdx, String lineText,
                Future previousFuture) {
            _lineIdx = lineIdx;
            _lineText = lineText;
            _futureToWaitForBeforePrinting = previousFuture;
        }

        public void run() {
            try {
                boolean matched = FIND_ME.matcher(_lineText).find();
                String currentThreadName = Thread.currentThread().getName();
                System.out.println("Thread " + currentThreadName
                        + " is done with its work on line " + _lineIdx);
                if (_futureToWaitForBeforePrinting != null) {
                    System.out.println("Thread " + currentThreadName
                            + " will wait for future "
                            + _futureToWaitForBeforePrinting
                            + " before printing its results.");
                    _futureToWaitForBeforePrinting.get();
                }
                System.out.println("RESULT: " + _lineIdx + " matched? "
                        + matched + " (Printed on Thread "
                        + currentThreadName + ")");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    final static String[] LINES = new String[] {
        "Sed ut perspiciatis unde omnis iste natus error sit voluptatem",
        "accusantium doloremque laudantium, totam rem aperiam, eaque ipsa",
        "quae ab illo inventore veritatis et quasi architecto beatae vitae",
        "dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas",
        "sit aspernatur aut odit aut fugit, sed quia consequuntur magni",
        "dolores eos qui ratione voluptatem sequi nesciunt. Neque porro",
        "quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur,",
        "adipisci velit, sed quia non numquam eius modi tempora incidunt",
        "ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad",
        "minima veniam, quis nostrum exercitationem ullam corporis",
        "suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur?",
        "Quis autem vel eum iure reprehenderit qui in ea voluptate velit",
        "esse quam nihil molestiae consequatur, vel illum qui dolorem eum",
        "fugiat quo voluptas nulla pariatur?" };

    // Match only words that are 11 characters or longer
    final static java.util.regex.Pattern FIND_ME = 
            java.util.regex.Pattern.compile("\\w{11,}");
}