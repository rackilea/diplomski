public class FileReader extends Thread {

  private final File file;
  private String[] lines;

  public FileReader(File file) {
    this.file = file;
  }

  @Override
  public void run() {
    // Read file here (populate `lines`)..
  }

  public String[] getLines() {
    return lines;
  }
}