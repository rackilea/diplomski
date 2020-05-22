package stack;

import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestIt {
    private static final Logger LOG = LoggerFactory.getLogger(TestIt.class);

    public static void main(String[] args) {
        MessageGroupTaskExecutor exe = new MessageGroupTaskExecutor(5, Executors.defaultThreadFactory());

        exe.init();

        for (int k = 0; k < 100; k++) {
            int messageGroup = (int) (Math.random() * 15.0);
            exe.execute(messageGroup, new MyTask(messageGroup, k));
        }
    }

    private static class MyTask implements Runnable {
        private int mg;
        private int taskNumber;

        public MyTask(int mg, int taskNumber) {
            this.mg = mg;
            this.taskNumber = taskNumber;
        }

        @Override
        public void run() {
            LOG.info("Doing task {} for message group {}", taskNumber, mg);
            try {
                Thread.sleep((long) (Math.random() * 500));
            } catch (InterruptedException e) {
            }
            LOG.info("Done task {} for message group {}", taskNumber, mg);
        }

    }
}