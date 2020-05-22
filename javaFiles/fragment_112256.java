ExecutorService pool = Executors.newFixedThreadPool(5);
do {

    Socket link = null;
    try {
        link = servSock.accept();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    Runnable task = new newClient2(link, "serverThread");
    pool.execute(task);

}
while (true);