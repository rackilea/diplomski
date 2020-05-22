AsyncHttpClient c = new AsyncHttpClient();
List<String> urls = getUrls();
List<Future<MyResultObject>> futures = new ArrayList<>();  // keep track of your futures
List<MyResultObject> results = new ArrayList<>();
for(String url : urls)
{
    // Create asynchronous request
    Future<MyResultObject> f = c.prepareGet(url).execute(handler);
    futures.add(f);
}

// Now retrieve the result
for (Future<MyResultObject> future : futures) {
  try {
    results.add(future.get());
  } catch (InterruptedException e) {
    e.printStackTrace();
  } catch (ExecutionException e) {
    e.printStackTrace();
  }
}
// continue with your result list