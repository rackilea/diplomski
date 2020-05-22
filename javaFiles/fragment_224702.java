BufferedImage oldimage = ImageIO.read(newfile);
BufferedImage tmp = Scalr.rotate(oldimage, Orientation);
oldimage.flush();
oldimage=tmp;
Iterator iter = ImageIO.getImageWritersByFormatName("jpeg");
ImageWriter writer = (ImageWriter)iter.next();
ImageWriteParam iwp = writer.getDefaultWriteParam();
iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
float quality=1.0f;
iwp.setCompressionQuality(quality);

FileImageOutputStream output = new FileImageOutputStream(newfile);
writer.setOutput(output);

IIOImage image = new IIOImage(oldimage, null, null);
writer.write(null, image, iwp);
writer.dispose();
output.close();