ExecutorService readerExecutor = Executors.newSingleThreadExecutor();
public startReadingSocket(Supplier<Socket> createSocket, Consumer<String> lineHandler, Consumer<Exception> excHandler, Runnable cleanUp) {
    readerExecutor.submit(() -> {
        String readLine;
        try (Socket s = createSocket.get();
             InputStreamReader isReader = new InputStreamReader(s.getInputStream());
             BufferedReader reader = new BufferedReader(isReader)) {
             while (readLine = reader.readLine() != null) {
                 lineHandler.accept(readLine);
             }
             System.out.println("client closed connection.");
        } catch (Exception e) {
            excHandler.accept(e);
        } finally {
            cleanUp.run();
        }
    }
}