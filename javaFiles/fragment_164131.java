import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceFutureCallableExample {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Future<String>> futuresList = new ArrayList<>();

        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorServiceFutureCallableExample.CallableTask callableTask1 = new ExecutorServiceFutureCallableExample.CallableTask(2000);
        ExecutorServiceFutureCallableExample.CallableTask callableTask2 = new ExecutorServiceFutureCallableExample.CallableTask(1000);
        ExecutorServiceFutureCallableExample.CallableTask callableTask3 = new ExecutorServiceFutureCallableExample.CallableTask(3000);

        System.out.println("### Starting submitting tasks");

        // submit the callable and register the returned future object so that it can be processed later.
        futuresList.add(executorService.submit(callableTask1));
        futuresList.add(executorService.submit(callableTask2));
        futuresList.add(executorService.submit(callableTask3));

        System.out.println("### Finished submitting tasks");

        for (int i = 0; i < futuresList.size(); i++) {
            // here "get()" waits for the future tasks to be returned.
            System.out.println(futuresList.get(i).get());
        }

        System.out.println("### Finished.");
    }

    static class CallableTask implements Callable<String>{

        private long timeToSleep;

        CallableTask(long _timeToSleep){
            this.timeToSleep = _timeToSleep;
        }

        @Override
        public String call() throws Exception {
            String str = new Date() + ": Processing - " + this.hashCode() + " | " + Thread.currentThread() + ", slept for seconds - " + timeToSleep; 
            System.out.println(str);
            Thread.sleep(timeToSleep);
            return str + " ||||| completed at: " + new Date();
        }

        public long getTimeToSleep() {
            return timeToSleep;
        }

        public void setTimeToSleep(long timeToSleep) {
            this.timeToSleep = timeToSleep;
        }

    }
}