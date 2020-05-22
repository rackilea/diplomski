import java.util.concurrent.Callable;

public class MyWorker implements Callable<MyWorkerResult> {

    private String _sqsMessage = null;

    public MyWorker(String sqsMessage) {
        _sqsMessage = sqsMessage;
    }

    @Override
    public MyWorkerResult call() throws Exception {
        // Do work relating to the SQS message
    }
}