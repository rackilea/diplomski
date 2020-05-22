public class MainActivity extends Activity {

  private static final String TAG = MainActivity.class.getSimpleName();
  private static final long MAX = 10;
  private static final String FILE_TXT = "file.txt";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    for (int i = 10; i <= 15; i++) {
      if (i > 10) {
        writeToFile(",");
      }
      writeToFile(Integer.toString(i));
    }
  }

  private void writeToFile(String text) {
    try {
      File f = new File(getFilesDir(), FILE_TXT);
      RandomAccessFile file = new RandomAccessFile(f, "rw");
      long currentLength = file.length();
      if (currentLength + text.length() > MAX) {
        file.setLength(0);
      }
      file.seek(file.length());
      file.write(text.getBytes());
      file.close();
    } catch (IOException e) {
      Log.e(TAG, "writeToFile()", e);
    }
    printFileContents();
  }

  private void printFileContents() {
    StringBuilder sb = new StringBuilder();
    try {
      FileInputStream fin = openFileInput(FILE_TXT);
      int ch;
      while ((ch = fin.read()) != -1) {
        sb.append((char) ch);
      }
      fin.close();
    } catch (IOException e) {
      Log.e(TAG, "printFileContents()", e);
    }
    Log.d(TAG, "current content: " + sb.toString());
  }
}