public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    CompletableFuture<String> userInput = CompletableFuture.supplyAsync(s::nextLine);
    while(!userInput.isDone()) {
        printData();
        try {
            userInput.get(1, TimeUnit.MINUTES);
        }
        catch(ExecutionException|InterruptedException ex) {} // handled after the loop
        catch(TimeoutException ex) {
            continue;
        }
    }
    String input = userInput.join();
    // handle input
}

private static void printData() {
    System.out.println("data");
}