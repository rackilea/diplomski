String st = "document.writeln(dat)";

BufferedImage image = null;
byte[] imageByte;

BASE64Decoder decoder = new BASE64Decoder();
imageByte = decoder.decodeBuffer(st);
ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
image = ImageIO.read(bis);
bis.close();

if (image != null)
    ImageIO.write(image, "jpg", new File("d://1.jpg"));
out.println("value=" + st);
System.out.println("value=" + st);