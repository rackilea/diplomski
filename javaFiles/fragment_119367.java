JFileChooser fc = new JFileChooser();
fc.setDialogTitle("Please choose an image...");
FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG", "jpeg", "jpg", "png", "bmp", "gif");
fc.addChoosableFileFilter(filter);

BufferedImage origImage = null;
// You should use the parent component instead of null
// but it was impossible to tell from the code snippet what that was.
if (fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
    File selectedFile = fc.getSelectedFile();
    try {
        origImage = ImageIO.read(selectedFile);
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}