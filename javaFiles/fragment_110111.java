final Stopwatch stopwatch = new Stopwatch();
stopwatch.start();

new HttpClientWrapper(httpClient).execute(request, new WithResponse<String>() {
    String withResponse(HttpResponse response) throws Exception {

        stopwatch.stop();
        MDC.put( "backendTime", String.valueOf( stopwatch.elapsed( TimeUnit.MILLISECONDS ) ) );

        // ...
    }
});