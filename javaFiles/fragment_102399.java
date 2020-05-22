BlockingQueue<MSG> queue = new LinkedBlockingQueue<MSG>();

// put a message in the queue
queue.put( msg );

// have a thread wait on the queue until something is available in it
MSG msg = queue.poll( 50, TimeUnit.SECONDS );