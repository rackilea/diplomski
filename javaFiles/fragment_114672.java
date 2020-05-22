public class JVMShutdownHookTest {
  public static void main(String[] args) {
    JVMShutdownHook jvmShutdownHook = new JVMShutdownHook();
    Runtime.getRuntime().addShutdownHook(jvmShutdownHook);
    System.out.println("JVM Shutdown Hook Registered.");
    System.out.println("Pre exit.");
    System.exit(0);
    System.out.println("Post exit.");
  }

  private static class JVMShutdownHook extends Thread {
    public void run() {
      System.out.println("JVM Shutdown Hook: Thread initiated.");
    }
  }
}

Output:
JVM Shutdown Hook Registered.
Pre exit.
JVM Shutdown Hook: Thread initiated.