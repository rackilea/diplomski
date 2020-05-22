private static Scanner in;

public String nextLine(int timeout) throws InterruptedException, ExecutionException
{
    //keep a reference to the current worker
    Worker worker = new Worker();
    Future<String> result = ex.submit(worker);
    try
    {
        return result.get(timeout, TimeUnit.MILLISECONDS);
    }
    catch (TimeoutException e)
    {
        //ask the worker thread to stop
        worker.interrupt();
        return null;
    }
}

private class Worker implements Callable<String>
{
    //you want the most up-to-date value of the flag, so 'volatile', though it's not really necessary
    private volatile boolean interrupt;

    @Override
    public String call() throws Exception
    {
        //check whether there's something in the buffer;
        while (System.in.available() == 0){
            Thread.sleep(20);
            //check for the interrupt flag
            if(interrupt){
                throw new InterruptedException();
            }
        }
        //once this method is called there's no friendly way back - that's why we checked for nr of available bytes previously
        return in.nextLine();
    }

    public void interrupt(){
        this.interrupt = true;
    }
}