JFileChooser fileChooser = new JFileChooser();
int returnVal = fileChooser.showOpenDialog(null);
if ( returnVal == JFileChooser.APPROVE_OPTION ){
    File file = fileChooser.getSelectedFile();
    ImageIO.write(image, 'jpg', file);//assuming you want a jpg, and BufferedImage variable name is image
}