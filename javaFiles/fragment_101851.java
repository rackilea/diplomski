@Async
@SqsListener(value = "sqsName", deletionPolicy = SqsMessageDeletionPolicy.NEVER)
public void consume(String message, Acknowledgment acknowledgment) throws InterruptedException, ExecutionException {

    //your code

    acknowledgment.acknowledge().get(); //To delete message from queue
}