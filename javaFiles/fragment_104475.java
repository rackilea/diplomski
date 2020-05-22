@Warmup(iterations = 1, time = 3, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 2, time = 5, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Threads(1)
public class HttpBenchmark {

    private static final String GOOGLE          = "https://google.com/";
    private static final String STACKOVERFLOW   = "https://stackoverflow.com";

    private final CloseableHttpClient httpClient = HttpClientBuilder.create().build();

    @Benchmark
    public void httpClientGoogle() throws Exception {
        httpClient(GOOGLE);
    }

    @Benchmark
    public void httpClientStackoverflow() throws Exception {
        httpClient(STACKOVERFLOW);
    }

    @Benchmark
    public void httpUrlConnectionGoogle() throws Exception {
        httpUrlConnection(GOOGLE);
    }

    @Benchmark
    public void httpUrlConnectionStackoverflow() throws Exception {
        httpUrlConnection(STACKOVERFLOW);
    }

    @Benchmark
    public void jsoupGoogle() throws Exception {
        jsoup(GOOGLE);
    }

    @Benchmark
    public void jsoupStackoverflow() throws Exception {
        jsoup(STACKOVERFLOW);
    }

    private void httpClient(final String url) throws Exception {
        final CloseableHttpResponse response = httpClient.execute(new HttpGet(url));
        final BasicResponseHandler basicResponseHandler = new BasicResponseHandler();
        basicResponseHandler.handleResponse(response);
        response.close();
    }

    private void httpUrlConnection(final String url) throws Exception {
        final HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
        httpURLConnection.addRequestProperty("Accept-Encoding", "gzip");
        try (final BufferedInputStream r = new BufferedInputStream(httpURLConnection.getInputStream())) {
            final byte[] tmp = new byte[1024 * 32];
            int read;
            while (true) {
                read = r.read(tmp);
                if (read == -1) {
                    break;
                }
            }
        }
    }

    private void jsoup(final String url) throws Exception {
        Jsoup.connect(url).execute().parse();
    }

}