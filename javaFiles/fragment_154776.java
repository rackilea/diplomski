import javax.swing.JFileChooser;
javax.swing.filechooser.FileSystemView;

public class GetMyDocuments {
  public static void main(String args[]) {
     JFileChooser fr = new JFileChooser();
     FileSystemView fw = fr.getFileSystemView();
     System.out.println(fw.getDefaultDirectory());
  }
}