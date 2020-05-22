// you create an empty image with same width and height of the original
    //BufferedImage out = new BufferedImage(in.getWidth(), in.getHeight(), in.getType());
      BufferedImage out = ImageIO.read(new File("path/to/Original/image")); 
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j=j+25) {
                out.setRGB(i,j,0);  
            }
        }