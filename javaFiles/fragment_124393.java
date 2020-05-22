String imgOriginalPath= "arch3.jpg";          
 String imgTargetPath= "arch3_resize.jpg"; 
 String imgFormat = "jpg";                          
 int newWidth = 200;                                  
 int newHeight = 300;                                 

 try{
    Image image = ImageIO.read(new File(imgOriginalPath));
    Image resizeImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
    BufferedImage newImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
    Graphics g = newImage.getGraphics();
    g.drawImage(resizeImage, 0, 0, null);
    g.dispose();
    ImageIO.write(newImage, imgFormat, new File(imgTargetPath));
 }catch (Exception e){e.printStackTrace();}