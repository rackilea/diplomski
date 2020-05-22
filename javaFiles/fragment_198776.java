ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
Future<InputStream> response1 = executor.submit(new Request("http://google.com"));
Future<InputStream> response2 = executor.submit(new Request("http://stackoverflow.com"));
// ...
ByteArrayOutputStream totalResponse = new ByteArrayOutputStream();
copyAndCloseInput(response1.get(), totalResponse);
copyAndCloseInput(response2.get(), totalResponse);
// ...
executor.shutdown();