/**
 * All the lambda handler class should extend this class.
 */
public abstract class AbstractEventHandler<I, O> implements RequestHandler<I, O> {

    @Override
    public O handleRequest(I input, Context context) {
        // As in our implementation, we have created child threads from our main thread
        // but in child threads, Thread ContextMap might not be available.
        // so we need to pass this by setting Log4j property
        // isThreadContextMapInheritable to true.
        System.setProperty("isThreadContextMapInheritable", "true");

        // Adding AWSRequestId in ThreadContext map.
        ThreadContext.put("AWSRequestId", context.getAwsRequestId());
        return requestHandler(input, context);
    }

    abstract protected O requestHandler(I input, Context context);
}