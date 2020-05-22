File inputFile = new File("image.png");
BufferedImage bufferedImage = ImageIO.read(inputFile);
int w = bufferedImage.getWidth();
int h = bufferedImage.getHeight(null);

//Get Pixels
int [] rgbs = new int[w*h];
bufferedImage.getRGB(0, 0, w, h, rgbs, 0, w); //Get all pixels