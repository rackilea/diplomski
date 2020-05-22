package stack;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageGroupTaskExecutor {

    private static final Logger LOG = LoggerFactory.getLogger(MessageGroupTaskExecutor.class);
    private static final long POLL_TIME = 10;

    private BlockingQueue<Runnable>[] queues;
    private Thread[] workerThreads;
    private volatile boolean stopped;
    private ThreadFactory threadFactory;

    public MessageGroupTaskExecutor(int numberOfThreads, ThreadFactory threadFactory) {
        this.threadFactory = threadFactory;
        this.queues = new BlockingQueue[numberOfThreads];
        this.workerThreads = new Thread[numberOfThreads];
    }

    public void init() {
        for (int k = 0; k < workerThreads.length; k++) {
            queues[k] = new LinkedBlockingQueue<Runnable>();
            workerThreads[k] = threadFactory.newThread(new WorkerThread(queues[k]));
            workerThreads[k].start();
        }
    }

    /**
     * Not a great impl - no way to "shutdown after all tasks finished" (at the moment...)
     */
    public void shutdown() {
        stopped = true;
        for (Thread thread : workerThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                LOG.warn("Interrupted waiting for thread to finish", e);
            }
        }
    }

    public void execute(int messageGroup, Runnable command) {
        queues[messageGroup % queues.length].add(command);
        LOG.debug("Submitted {} for message group {}", command, messageGroup);
    }

    private class WorkerThread implements Runnable {

        private BlockingQueue<Runnable> queue;

        public WorkerThread(BlockingQueue<Runnable> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (!stopped) {
                Runnable nextJob = null;
                try {
                    nextJob = queue.poll(POLL_TIME, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    LOG.debug("Interrupted when polling queue", e);
                }

                if (nextJob != null) {
                    try {
                        LOG.debug("Got job " + nextJob);
                        nextJob.run();
                        LOG.debug("Completed " + nextJob);
                    } catch (Exception ex) {
                        LOG.debug("Exception thrown by " + nextJob, ex);
                    }
                }
            }
        }
    }
}