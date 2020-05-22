@Component("yourRetryPolicy")
public class YourRetryPolicy extends ExceptionClassifierRetryPolicy
{
    @PostConstruct
    public void init()
    {
        final SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy();
        simpleRetryPolicy.setMaxAttempts( 3 );

        this.setExceptionClassifier( new Classifier<Throwable, RetryPolicy>()
        {
            @Override
            public RetryPolicy classify( Throwable classifiable )
            {
                    if ( classifiable instanceof YourException )
                    {
                            return new NeverRetryPolicy();
                    }
                    // etc...
                    return simpleRetryPolicy;
            }
        });
    }
}