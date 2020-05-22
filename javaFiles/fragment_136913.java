public void process(InputStream xmlStream) {
    ExecutorService threadPool = Executors.newFixedThreadPool(2);
    ExecutorCompletionService<Void> ecs = new ExecutorCompletionService<>(threadPool);

    final BufferedInputStream bufferedXmlStream = new BufferedInputStream(xmlStream);

    PipedInputStream pipedJsonInputStream = new PipedInputStream();
    final PipedOutputStream jsonStream = new PipedOutputStream(pipedJsonInputStream);

    ecs.submit( new Callable<Void>() {
       @Override
       public Void call() {
          // put your code that writes data to the outputstream here.
          try {
              XML.toJson(bufferedXmlStream, jsonStream, true);
          } catch (Exception e) {
              e.printStackTrace();
              throw e;
          }
          return null;
        }
    });

    ecs.submit( new Callable<Void>() {
       @Override
       public Void call() {
          try {
              // use reader to further process json in main thread...
              parseJsonStream(reader);
          } finally {
              reader.close();
              jsonStream.close();
          }
          return null;
      }
    });

    // Wait for all tasks to be done.
    // Kill the other thread if one hits an exception.
    try {
        for (int i = 0; i < 2; ++i) {
            ecs.take().get();
        }
    } finally {
        threadPool.shutdownNow();
    } 
}