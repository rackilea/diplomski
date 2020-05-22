public abstract class SecurityManager {

  private static final ThreadLocal<String> agentContext = new ThreadLocal<String>();

  private SecurityManager() { }

  public static void clearManager() {
      agentContext.set(null);
  }


  public static String getAgent() {
      String os = agentContext.get();
      if (os == null) {
          os = CrossAppConstants.DEFAULT_OS;
      }
      return os;
  }

  public static void setAgent(String agent) {
      System.out.println("### os detected: " + agent);
      agentContext.set(agent);
  }

}