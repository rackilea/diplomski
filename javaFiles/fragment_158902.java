public class ExecutorCloseable extends Foo implements AutoCloseable 
{
  @Override
  public void execute() 
  {
    // ...
  }

  @Override           //this one comes from AutoCloseable
  public void close() //<--will be called after execute is finished
  {
     super.finish();
  }
 }