URL imageURL = new URL(profileImgUrl);
BufferedImage originalImage=ImageIO.read(imageURL);
ByteArrayOutputStream baos=new ByteArrayOutputStream();
ImageIO.write(originalImage, "jpg", baos );

//Persist - in this case to a file

FileOutputStream fos = new FileOutputStream("outputImageName.jpg");
baos.writeTo(fos);
fos.close();