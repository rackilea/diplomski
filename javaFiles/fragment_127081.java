public class MyRejectedExecutionHandler implements RejectedExecutionHandler {



@Override
public void rejectedExecution(Runnable worker, ThreadPoolExecutor executor) {
    // TODO Auto-generated method stub
    System.out.println(worker.toString()+" is Rejected");

    System.out.println("Retrying to Execute");
    try{
        //Re-executing with alternateExecutor
        MainClass.alternateExecutor.execute(worker);
        System.out.println(worker.toString()+" Execution Started");
    }
    catch(Exception e)
    {
        System.out.println("Failure to Re-exicute "+e.getMessage());
    }
}

}