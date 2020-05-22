Scanner s = new Scanner(System.in);
for(boolean quit = false; !quit; ) {
    CompletableFuture<String> userInput = CompletableFuture.supplyAsync(s::nextLine);
    while(!userInput.isDone()) {
        printData();
        try {
            userInput.get(1, TimeUnit.MINUTES);
        }
        catch(ExecutionException|InterruptedException ex) {} // handled implicitly
        catch(TimeoutException ex) {
            continue;
        }
    }
    String input = userInput.join();
    // handle input
    if(input.equals("exit")) quit = true;
}