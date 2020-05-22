public static void main(String[] args) throws Exception {
    final URI uri = new URI("http://stackoverflow.com");
    for (int i = 0; i < 5; i++) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().interrupt();
                System.out.println(Thread.currentThread().isInterrupted());
                try {
                    Socket socket = new Socket (uri.getHost(), uri.getPort() == -1 ? 80 : uri.getPort());
                }
                catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().isInterrupted());
            }
        };
        new Thread(r).start();
    }
}