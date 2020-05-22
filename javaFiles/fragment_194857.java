public class Channel<T extends Something> {
  public Channel() {
  }

  public <T extends Something> void method(T foo) {
  }
}

public class Manager {
   private static ArrayList<Channel<? extends Something>> channels = new ArrayList<Channel<? extends Something>>();

   public static <T extends Something> void OtherMethod(T foo) {
     for (Channel<? extends Something> c : channels)
        c.method(foo); // this does not work
   }
}