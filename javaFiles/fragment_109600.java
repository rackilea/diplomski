Runnable sayHelloJob = new Runnable()
{
    @Override
    public void run ( )
    {
        System.out.println( "Hello. " + Instant.now() );
    }
};