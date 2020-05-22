public class LocationFinder extends Thread {

  public LocationFinder( Context ctx ) {
   this.ctx = ctx;
  }

  public void start( String userId ) {
    this.userId = userId;
    super.start();
  }

  //defensive programming : prevent your thread from beeing started in an undesired way
  @Override 
  public void start() {
    throw new IllegalStateException( "LocationFinder can't be started using start(). Prefer start( int )." );
  }

  public void run() {
    //remaining of the code of startLocation except the first line.
  }

}