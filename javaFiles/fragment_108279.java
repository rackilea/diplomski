import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class BatchMessageProcessingExample {

    private static final int BATCH_SIZE = 20;

    //Having 20 here may not entirely benefit you. Chosing this number depends on a lot of stuff.
    // Its usually better to go with total number of cores you have
    private final ExecutorService pool = Executors.newFixedThreadPool(BATCH_SIZE);

    private final ScheduledExecutorService databasePool = Executors.newScheduledThreadPool(1);

    public void schedule() {
        databasePool.scheduleWithFixedDelay(() -> runBatchProcess(), 0, 1, TimeUnit.MINUTES); //Schedule the database work to execute every minute
    }

    private void runBatchProcess() {
        List<Message> taskFromDbFetch = getMessagesFromDb(); //Get stuff from the db
        CountDownLatch countDownLatch = new CountDownLatch(taskFromDbFetch.size()); //Create a latch having same size as the list

        List<Task> taskList = taskFromDbFetch.stream().map(x -> new Task(countDownLatch, x)).collect(Collectors.toList()); // Create tasks using the messages and the countdown latch

        taskList.forEach(pool::execute); //Submit them all in pool

        CompletableFuture.runAsync(() -> sendEmailAfterCompletion(countDownLatch)); //Send an email out from a separate thread
    }

    private void sendEmailAfterCompletion(CountDownLatch countDownLatch) {
        try {
            countDownLatch.await();//Await on the latch for the batch tasks to complete
            sendEmail();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void sendEmail() {
        System.out.println("Sending out an email.");
    }

    private List<Message> getMessagesFromDb() { //Get your messages from db here
        List<Message> messages = new ArrayList<>();

        for(int i = 0; i < BATCH_SIZE; i++) {
            final int taskNumber = i;
            messages.add(() -> System.out.println("I am a db message number " + taskNumber));
        }

        return messages;
    }

    class Task implements Runnable {

        private final CountDownLatch countDownLatch;

        private final Message message;

        public Task(CountDownLatch countDownLatch, Message message) {
            this.countDownLatch = countDownLatch;
            this.message = message;
        }

        @Override
        public void run() {
            message.process(); //Process the message
            countDownLatch.countDown(); //Countdown the latch
        }
    }

    interface Message {
        void process();
    }

    public static void main(String[] args) {
        new BatchMessageProcessingExample().schedule();
    }

}