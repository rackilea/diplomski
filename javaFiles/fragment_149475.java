public class MyTask implements Runnable {

  private final Queue output;

  /** 'q' must be thread safe */
  public MyTask( Queue q ) {
    output = q;
  }

  @Override
  public void run() {

    // do stuff

    int [] path = ...
    output.add( path );
  }

}