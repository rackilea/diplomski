public class AsyncFileHandler extends FileHandler implements Runnable {

        private static final int offValue = Level.OFF.intValue();
        private final BlockingQueue<LogRecord> queue = new ArrayBlockingQueue<>(5000);
        private volatile Thread worker;

        public AsyncFileHandler() throws IOException {
            super();
        }

        public AsyncFileHandler(String pattern, int limit, int count, boolean append)
                throws IOException {
            super(pattern, limit, count, append);
        }

        @Override
        public void publish(LogRecord record) {
            int levelValue = getLevel().intValue();
            if (record.getLevel().intValue() < levelValue || levelValue == offValue) {
                return;
            }

            final Thread t = checkWorker();
            record.getSourceMethodName(); //Infer caller.
            boolean interrupted = Thread.interrupted();
            try {
                for (;;) {
                    try {
                        boolean offered = queue.offer(record, 10, TimeUnit.MILLISECONDS);
                        if (t == null || !t.isAlive()) {
                            if (!offered || queue.remove(record)) {
                                handleShutdown(record);
                            }
                            break;
                        } else {
                            if (offered || handleFullQueue(record)) {
                                break;
                            }
                        }
                    } catch (InterruptedException retry) {
                        interrupted = true;
                    }
                }
            } finally {
                if (interrupted) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        private boolean handleFullQueue(LogRecord r) {
            super.publish(r);
            return true; //true if handled.
        }

        private void handleShutdown(LogRecord r) {
            super.publish(r);
        }

        @Override
        public void close() {
            try {
                try {
                    final Thread t = this.worker;
                    if (t != null) {
                        t.interrupt();
                        shutdownQueue();
                        t.join();
                        shutdownQueue();
                    }
                } finally {
                    super.close();
                }
            } catch (InterruptedException reAssert) {
                Thread.currentThread().interrupt();
            }
        }

        private void shutdownQueue() {
            for (LogRecord r; (r = queue.poll()) != null;) {
                handleShutdown(r);
            }
        }

        @Override
        public void run() {
            try {
                final BlockingQueue<LogRecord> q = this.queue;
                for (;;) {
                    super.publish(q.take());
                }
            } catch (InterruptedException shutdown) {
                shutdownQueue();
                Thread.currentThread().interrupt();
            }
        }

        private Thread checkWorker() {
            Thread t = worker;
            if (t == null) {
                t = startWorker();
            }
            return t;
        }

        private synchronized Thread startWorker() {
            if (worker == null) {
                worker = Executors.defaultThreadFactory().newThread(this);
                worker.setDaemon(true);
                worker.setContextClassLoader(getClass().getClassLoader());
                worker.start();
            }
            return worker;
        }
    }