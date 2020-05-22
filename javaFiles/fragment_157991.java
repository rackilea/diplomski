public class Printer implements Closeable {
  private PrintWriter pw;
  private boolean error;

  public Printer(String name) {
    try {
      pw = new PrintWriter(name, "UTF-8");
      pw.print('\uFEFF'); // BOM
      error = false;
    } catch (IOException e) {
      error = true;
    }
  }

  public void print(String s) {
    if (pw == null) return;
    pw.print(s);
    pw.flush();
  }

  public boolean checkError() { return error || pw.checkError(); }

  @Override public void close() { if (pw != null) pw.close(); }
}