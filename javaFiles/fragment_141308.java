public static void main(String[] args) throws IOException
   {
      BufferedImage spritesheet =
            ImageIO.read(new FileInputStream("/tmp/GYBOD.gif"));
      BufferedImage copy = new BufferedImage(spritesheet.getWidth(), spritesheet.getHeight(), BufferedImage.TYPE_BYTE_INDEXED);
      for(int xx = 0; xx < spritesheet.getWidth(); xx++) {
         Color color = new Color(200, 180, 110);
         for(int yy = 0; yy < spritesheet.getHeight(); yy++) {
            if(spritesheet.getRGB(xx, yy) == new Color(0, 0, 0).getRGB()) {
               //spritesheet.setRGB(xx, yy, color.getRGB());
               copy.setRGB(xx, yy, color.getRGB());
            }
            else {
               copy.setRGB(xx, yy, spritesheet.getRGB(xx,yy));
            }
         }
      }

      ImageWriter writer = ImageIO.getImageWritersBySuffix("gif").next();
      writer.setOutput(ImageIO.createImageOutputStream(new FileOutputStream("/tmp/test.gif")));
      writer.write(copy);

   }
}