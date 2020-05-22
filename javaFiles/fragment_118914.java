@MyConfig
class MyConfiguration {
  private static MyConfiguration INSTANCE = null;

  public static MyConfiguration getInstance() {
    // note this is not thread-safe
    // see the above link for several thread-safe modifications
    if(INSTANCE == null) {
      INSTANCE = new MyConfiguration();
    }
    return INSTANCE;
}