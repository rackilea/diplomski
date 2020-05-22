public class Processor {

private int taskNo = 0; // the number of the current task
                        // (0 = there is no task, but will be)
                        // (-1 = there won't be more task)

public void produce() throws InterruptedException {
    synchronized (this) {
        for (int i = 0; i < 100; i++) {
            taskNo = i + 1; // making a task number (i+1)
            System.out.println("Trainer making " + taskNo + " Task...");
            notify(); // notifies the consumer that the task was made
            wait(); // and waiting the consumer to finish... zzzz...
            System.out.println("");
        }
        taskNo = -1; // there will be no more task
        notify(); // notify the consumer about it
    }
}

public void consume() throws InterruptedException {
    synchronized (this) {
        do {
            if (taskNo == 0) {
                wait(); // there is no task to do, waiting... zzzz...
            }
            if (taskNo != -1) {
                System.out.println("Sportman doing " + taskNo + " Task...");
                taskNo = 0; // sets the task to done
                notify(); // notifies the producer that the task was done
            }
        } while (taskNo != -1);
    }
}
}