try
 {
Blob image_vis = rs1.getBlob("blobColumn");
int blobLength = (int) image_vis.length();  

byte[] bytes = image_vis.getBytes(1, blobLength);
image_vis.free();
final BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(bytes));
ImageIO.write(bufferedImage, "jpg", new File("ImagePath/ImageName.jpg"));
}