//  This works using ImageIO

imageLabel.setIcon( new ImageIcon(ImageIO.read( new File(imageName) ) ) );

//  Or you can flush the image

ImageIcon icon = new ImageIcon(imageName);
icon.getImage().flush();
imageLabel.setIcon( icon );