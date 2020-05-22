import java.util.ArrayList;
    import java.util.Collection;
    import java.util.Date;
    import java.util.List;
    import java.util.concurrent.Callable;
    import java.util.concurrent.CompletionService;
    import java.util.concurrent.ExecutionException;
    import java.util.concurrent.ExecutorCompletionService;
    import java.util.concurrent.Executors;
    import java.util.concurrent.Future;
    import java.util.concurrent.TimeUnit;

    class TaskWorker implements Callable {
        private final int number;

        public TaskWorker(int number) {
            this.number = number;
        }

        public Boolean call() throws InterruptedException {
            while (!Thread.currentThread().isInterrupted()) {
                myBusyFunction();
            }
            return true;
        }

        private boolean isValid() {
            return true;
        }

        private void myBusyFunction() {
            //while (isValid()) {
            System.out.println(number + ">....Working.....");
            //}
        }
    }

    public class Test {
        public static void main(final String[] args) {
            CompletionService cs = new ExecutorCompletionService(Executors.newFixedThreadPool(1));
            Collection tasks = new ArrayList(10);
            tasks.add(new TaskWorker(1));
            List> futures = new ArrayList>(tasks.size());
            try {
                for (Callable task : tasks) {
                    futures.add(cs.submit(task));
                }
                //----
                for (int t = 0; t  result = cs.poll(10, TimeUnit.SECONDS);
                    if (result == null) {
                        System.out.println(new Date() + ":Worker Timedout:");
                        //So lets cancel the first futures we find that havent completed
                        for (Future future : futures) {
                            System.out.println("Checking future");
                            if (future.isDone()) {
                                continue;
                            } else {
                                future.cancel(true);
                                System.out.println("Cancelled");
                                break;
                            }
                        }
                        continue;
                    } else {
                        try {
                            if (result.isDone() && !result.isCancelled() && result.get()) {
                                System.out.println(new Date() + ":Worker Completed:");
                            } else if (result.isDone() && !result.isCancelled() && !result.get()) {
                                System.out.println(new Date() + ":Worker Failed");
                            }
                        } catch (ExecutionException ee) {
                            ee.printStackTrace(System.out);
                        }
                    }
                }
            } catch (InterruptedException ie) {
            } finally {
                //Cancel by interrupting any existing tasks currently running in Executor Service
                for (Future f : futures) {
                    f.cancel(true);
                }
            }
            System.out.println(new Date() + ":Done");
        }
    }