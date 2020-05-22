while(!Thread.currentThread().isInterrupted()) // <- something of the sort here
{
    try{
        // do work
    } catch (InterruptedException e){
        // clean up
    }
}