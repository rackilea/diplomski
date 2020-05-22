public class FileNode extends DefaultMutableTreeNode {
  private File file;

  public FileWrapper(File file) {
    super(this);
    this.file = file;
    if(file.isDirectory()) {
      for(File file : listFiles) {
        add(new FileNode(file));
      }
    }
  }

  private String toString() {
    return file.getName();
  }

  private File getFile() {
    return file;
  }

}