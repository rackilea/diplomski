package example

import java.io.File;
import javax.swing.filechooser.FileFilter;

class JPGSaveFilter extends FileFilter {
  @Override
  public boolean accept(File f) {
    if (f.isDirectory()) {
      return false;
    }

    String s = f.getName().toLowerCase();

    return s.endsWith(".jpg");
  }

  @Override
  public String getDescription() {
    return "*.jpg,*.JPG";
  }
}