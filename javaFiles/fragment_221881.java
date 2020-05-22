ExecutorService executor = Executors.newFixedThreadPool(10);
List<Future<statusModel>> futures = new ArrayList<>();

for (Map.Entry<String, String> url : urls.entrySet())
{
    futures.add(executor.submit(new CallableRequestStatus(url.getValue())));
}
for (Future<statusModel> f : futures) {
    results.add((statusModel) f.get(5, TimeUnit.SECONDS));
}