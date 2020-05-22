Artwork aw = tag.getFirstArtwork();
ByteArrayInputStream bis = new ByteArrayInputStream(aw.getBinaryData());

BufferedImage tempImg = ImageIO.read(bis);

File tempFile = new File("temp.jpg");
ImageIO.write(tempImg, "jpg", tempFile);

BufferedImage imgA = ImageIO.read(tempFile);

File expectedImageFile = new File("imgToCheckAgainst.jpg");
BufferedImage imgB = ImageIO.read(expectedImageFile);

if(compareImages(imgA, imgB)) {
    System.out.println("The Images Match");
}else {
    System.out.println("The images do not match.");
}

tempFile.delete();