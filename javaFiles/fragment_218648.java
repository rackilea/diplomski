JFileChooser fc = new JFileChooser("C:/");
fc.addChoosableFileFilter(new JPGSaveFilter());
fc.addChoosableFileFilter(new JPEGSaveFilter());
fc.addChoosableFileFilter(new PNGSaveFilter());
fc.addChoosableFileFilter(new GIFSaveFilter());
fc.addChoosableFileFilter(new BMPSaveFilter());
fc.addChoosableFileFilter(new WBMPSaveFilter()); 

int retrieval = fc.showSaveDialog(null);

if (retrieval == JFileChooser.APPROVE_OPTION) {
  String ext = "";

  String extension = fc.getFileFilter().getDescription();

  if (extension.equals("*.jpg,*.JPG")) {
    ext = ".jpg";
  } else if (extension.equals("*.png,*.PNG")) {
    ext = ".png";
  } else if (extension.equals("*.gif,*.GIF")) {
    ext = ".gif";
  } else if (extension.equals("*.wbmp,*.WBMP")) {
    ext = ".wbmp";
  } else if (extension.equals("*.jpeg,*.JPEG")) {
    ext = ".jpeg";
  } else if (extension.equals("*.bmp,*.BMP")) {
    ext = ".bmp";
  }
}