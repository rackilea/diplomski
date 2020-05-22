BufferedImage img = null;
try {
    img = ImageIO.read(new File("C:\\Users\\xxxxx\\Desktop\\testbinary.png"));
} catch (IOException e) {
   e.printStackTrace(); // never leave this block empty ********** 
   // exit program here?
}

ColorModel cm = img.getColorModel();

for (int y=0; y<img.getHeight(); ++y) {
    for (int x=0; x<img.getWidth(); ++x) {
        System.out.println(img.getRGB(y, x));
        // ColorModel cm = new ColorModel(img.getRGB(y, x));
    }
}