public void doSomething(){
    try
    {
        doSomethingImpl(); // throws RejectedExecutionException
    }
    catch (RejectedExecutionException ex)
    {
        // just add some metrics here, no big action
    }
}.