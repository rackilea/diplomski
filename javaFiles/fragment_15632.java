public static class MyDirectoryFilter extends javax.swing.filechooser.FileFilter {
  @Override
  public boolean accept( File file ) {
    return file.isDirectory() && customeCondition(file) ;
  }

  @Override
  public String getDescription() {
    return "this only my custom dir";
  }
}

myChooser.setFileFilter( new MyDirectoryFilter () );