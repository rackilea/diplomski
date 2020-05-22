public static void main(final String... args) {
  final ExecutorService es = Executors.newFixedThreadPool(20);
  final String ip = "127.0.0.1";
  final int timeout = 200;
  final List<Future<Boolean>> futures = new ArrayList<>();
  for (int port = 1; port <= 65535; port++) {
    futures.add(portIsOpen(es, ip, port, timeout));
  }
  es.shutdown();
  int openPorts = 0;
  for (final Future<Boolean> f : futures) {
    if (f.get()) {
      openPorts++;
    }
  }
  System.out.println("There are " + openPorts + " open ports on host " + ip + " (probed with a timeout of " + timeout + "ms)");
}