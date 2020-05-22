import java.io.*;
import java.awt.Desktop;

public class LaunchNotepad {
  public static void main(String[] args) throws IOException {
    File program = new File("C:\\Windows\\notepad.exe");
    Desktop.getDesktop().open(program);
  }
}