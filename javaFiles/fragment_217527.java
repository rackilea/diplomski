import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SqsProcessor {

    private static final int THREAD_COUNT = 100;
    private ExecutorService _executor = null;
    private FutureResultProcessor futureResultProcessor = null;

    public SqsProcessor() {
        _executor = Executors.newFixedThreadPool(THREAD_COUNT);
        _futureResultProcessor = new FutureResultProcessor();
    }

    public void waitReceive() {

        // Receive a SQS message

        // Start the work related to the SQS message
        Callable<MyWorkderResult> sqsWorker = new MyWorker(sqsMessage);
        Future<MyWorkerResult> sqsFuture = _executor.submit(sqsWorker);

        // Send to the queue so the result can be processed when it completes
        _futureResultProcessor.add(sqsFuture);
    }
}