Future<String> future = executor.submit(new Callable<String>() {
    public String call() {
        return webService.executeServiceMethod();
    }
});
try {
    String result = future.get(5, TimeUnit.SECONDS);
    processResult(result);
} catch (TimeoutException ex) {
    displayMessageToUserOrExecuteAgain();
}