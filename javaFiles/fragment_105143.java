public class StartWindowMinimized {

  public static void main(String[] args) throws IOException {
    if (args.length != 1) {
      System.err
          .println("Expected: one argument; the command to launch minimized");
    }
    String cmd = "cmd.exe /C START /MIN ";
    Runtime.getRuntime().exec(cmd + args[0]);
  }

}