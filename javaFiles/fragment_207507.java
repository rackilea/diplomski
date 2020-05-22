Process process = Runtime.getRuntime().exec("cat ");

ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(2);

Future<String> output = newFixedThreadPool.submit(() -> {
    return IOUtils.toString(process.getInputStream());
});
Future<String> error = newFixedThreadPool.submit(() -> {
    return IOUtils.toString(process.getErrorStream());
});

newFixedThreadPool.shutdown();

// process.waitFor();
if (!process.waitFor(3, TimeUnit.SECONDS)) {
    System.out.println("Destroy");
    process.destroy();
}

System.out.println(output.get());
System.out.println(error.get());