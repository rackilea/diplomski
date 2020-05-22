public class DiscoverRunnable implements Callable<Boolean> {
  InetAddress address = null;
  boolean discovered;

  public DiscoverRunnable(InetAddress address){
        this.address = address;
        boolean discovered = false;
  }

  @Override
  public Boolean call(){
        //some crazy stuff
        //may set discovered = true
     return discovered;
  }