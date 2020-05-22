Set<Integer> colors = new HashSet<Integer>();
    BufferedImage image = ImageIO.read(new File("test.png"));    
    int w = image.getWidth();
    int h = image.getHeight();
    for(int y = 0; y < h; y++) {
        for(int x = 0; x < w; x++) {
            int pixel = image.getRGB(x, y);     
            colors.add(pixel);
        }
    }
    System.out.println("There are "+colors.size()+" colors");