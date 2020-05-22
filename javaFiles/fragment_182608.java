public enum Lambdas
{
    FIRST( s -> new String()),
    SECOND( s -> s + " ");

    private Function<String, String> myLambda;

    private Lambdas( Function<String, String> aLambda )
    {
        myLambda = aLambda;
    }

    public Function<String, String> getLambda()
    {
        return myLambda;
    }
}