public static void main(String[] args) {
  final ShellSession shellSession = ...

  Thread input = new Thread() {
    @Override public void run() {
      byte[] buffer = new byte[1024];
      while(!shellSession.isClosed()) {
        int read = System.in.read(buffer);
        shellSession.getInputStream().write(buffer, read);
      }
    }
  }

  Thread output = ...
  Thread error = ...

  input.start();
  output.start();
  error.start();

}