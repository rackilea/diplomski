static class RestRunnable implements Runnable {
    private final String url;
    private final RestTemplate restTemplate;
    private final Collection<? super String> executedUrls;

    RestRunnable(
            final String url,
            final RestTemplate restTemplate,
            final Collection<? super String> executedUrls) {
        this.url = url;
        this.restTemplate = restTemplate;
        this.executedUrls = executedUrls;
    }

    @Override
    public void run() {
        final ResponseEntity<?> response = restTemplate.exchange(...);

        if (response.getStatusCode() == HttpStatus.OK) {
            executedUrls.add(url);
        }
    }
}