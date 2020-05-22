import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;

public class JobExecutor {
    ExecutorService executorService = Executors.newFixedThreadPool(1);

    private class Task implements Runnable {
        private final String name;
        private final Task[] subtasks;
        private final ExecutorService executorService;
        private volatile boolean started = false;
        private Future<?> taskFuture;

        // Separate list from subtasks because this is what you'll probably
        // actually use as you may not be passing subtasks as constructor args
        private final List<Task> subtasksToWaitOn = new ArrayList<Task>();

        public Task(String name, ExecutorService executorService,
                Task... subtasks) {
            this.name = name;
            this.executorService = executorService;
            this.subtasks = subtasks;
        }

        public synchronized void start() {
            if (!started) {
                started = true;
                taskFuture = executorService.submit(this);
            }
        }

        public synchronized void blockTillDone() {
            if (started) {
                try {
                    taskFuture.get();
                } catch (InterruptedException e) {
                    // TODO Handle
                } catch (ExecutionException e) {
                    // TODO Handle
                }
                for (Task subtaskToWaitOn : subtasksToWaitOn) {
                    subtaskToWaitOn.blockTillDone();
                }
            } else {
                // TODO throw exception
            }
        }

        @Override
        public void run() {
            for (Task subtask : subtasks) {
                subtask.start();
                subtasksToWaitOn.add(subtask);
            }
            System.out.println("My name is: " + name);
        }
    }

    void testSubmit() {
        Task subsubTask1 = new Task("Subsubtask1", executorService);
        Task subtask1 = new Task("Subtask1", executorService, subsubTask1);
        Task subtask2 = new Task("Subtask2", executorService);
        Task subtask3 = new Task("Subtask3", executorService);
        Task job = new Task("Job", executorService, subtask1, subtask2,
                subtask3);
        job.start();
        job.blockTillDone();
        System.out.println("Job done!");
    }

    public static void main(String[] args) {
        new JobExecutor().testSubmit();
    }
}