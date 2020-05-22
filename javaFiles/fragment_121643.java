final Collection<String> urls = new ArrayList<>();
final Collection<String> executedUrls = new CopyOnWriteArrayList<>();

...

for (final String url : urls) {
    // The RestTemplate instance is retrieved via Spring Bean, or created manually 
    executorService.submit(new RestRunnable(url, restTemplate, executedUrls));
}