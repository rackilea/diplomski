File input = new File("C:\\File\\1.tif");

BufferedImage image = ImageIO.read(input);
// Here we convert into *supported* format
BufferedImage imageCopy =
    new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_3BYTE_BGR);
imageCopy.getGraphics().drawImage(image, 0, 0, null);

byte[] data = ((DataBufferByte) imageCopy.getRaster().getDataBuffer()).getData();  
Mat img = new Mat(image.getHeight(),image.getWidth(), CvType.CV_8UC3);
img.put(0, 0, data);           
Imgcodecs.imwrite("C:\\File\\input.jpg", img);