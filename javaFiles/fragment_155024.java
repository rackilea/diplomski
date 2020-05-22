Blob blob = rs.getBlob("img");
int blobLength = (int) blob.length();  

byte[] bytes = blob.getBytes(1, blobLength);
blob.free();
BufferedImage img = ImageIO.read(new ByteArrayInputStream(bytes));
ImageIO.write(img, "png", new File("..."));