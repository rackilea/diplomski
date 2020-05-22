BlockingQueue bq = new BlockingQueue(10);
Thread p = new Thread(new Producer(bq));
Thread c = new Thread(new Consumer(bq));
c.setDaemon(true);
c.start();
p.start();