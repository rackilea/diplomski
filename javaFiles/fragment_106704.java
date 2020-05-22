private final static AtomicBoolean stopStreams = new AtomicBoolean(false);

public static void main(String[] args) {
  // do stuff

  KafkaStreams streams = ...
  stream.setUncaughtExceptionHandler((t, e) -> {
    stopStreams.set(true);
  });

  Runtime.getRuntime().addShutdownHook(new Thread(() -> {
    stopStreams.set(true);
  });

  while (!stopStreams.get()) {
    Thread.sleep(1000);
  }
  streams.close();
}