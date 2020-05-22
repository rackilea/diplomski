public class MatchProcessor {
    private static final ExecutorService service = Executors.newFixedThreadPool(THREADS);

    public static void processMatchList(final JSONObject matchList) {
        service.submit(() -> runAnalysis(matchList));
    }

    private static void runAnalysis(final JSONObject matchList) {
       //processing goes here
    }
}