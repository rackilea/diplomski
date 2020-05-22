File input = new File("inputImage.jpg");

BufferedImage image = ImageIO.read(input); 

Raster ras = image.getRaster();

int elem = ras.getNumDataElements();

System.out.println("Number of Elems: " + elem);