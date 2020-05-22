public class MultiThreadedLineSearcher {

    public static void main(String[] args) throws Exception {
        Thread previousThread = null;
        for (int i = 0; i < LINES.length; i++) {
            JobRunnable job = new JobRunnable(i, LINES[i], previousThread);
            Thread thread = new Thread(job, "T-" + i);
            thread.start();
            previousThread = thread;
        }
        if (previousThread != null) {
            previousThread.join();
        }
        System.out.println("Program done.");
    }

    public static class JobRunnable implements Runnable {
        private final int _lineIdx;
        private final String _lineText;
        private final Thread _threadToWaitForBeforePrinting;

        public JobRunnable(int lineIdx, String lineText,
                Thread threadToWaitForBeforePrinting) {
            _lineIdx = lineIdx;
            _lineText = lineText;
            _threadToWaitForBeforePrinting = threadToWaitForBeforePrinting;
        }

        public void run() {
            try {
                boolean matched = FIND_ME.matcher(_lineText).find();
                String currentThreadName = Thread.currentThread().getName();
                System.out.println("Thread " + currentThreadName
                        + " is done with its work.");
                if (_threadToWaitForBeforePrinting != null) {
                    System.out.println("Thread " + currentThreadName
                            + " will wait for thread "
                            + _threadToWaitForBeforePrinting.getName()
                            + " before printing its results.");
                    _threadToWaitForBeforePrinting.join();
                }
                System.out.println("RESULT: " + _lineIdx + " matched? "
                        + matched + " (Printed on Thread "
                        + currentThreadName + ")");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
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