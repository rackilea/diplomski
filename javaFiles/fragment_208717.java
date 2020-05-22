JFileChooser jf=new JFileChooser();
jf.setFileView(new MyFileView());
jf.showOpenDialog(this);

class MyFileView extends FileView
{
      public Icon getIcon(File f)
      {
      FileSystemView view=FileSystemView.getFileSystemView();
            return view.getSystemIcon(f);
      }
}