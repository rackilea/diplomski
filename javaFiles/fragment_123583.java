BufferedImage myImage = new BufferedImage(1250, 950,BufferedImage.TYPE_INT_RGB );
Graphics2D delegate = myImage.createGraphics();
delegate.setClip(0,0,1250,950);
Graphics2D graphics = new Graphics2DWrapper(delegate);
frame.paintAll(graphics);
try{
ImageIO.write(myImage, "jpg", new File(fileChooser.getSelectedFile().toString() + ".jpg"));
}catch (IOException exception){
    exception.printStackTrace();
}