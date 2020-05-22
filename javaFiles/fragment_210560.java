String fp = "C:\\Users\\Nick\\Desktop\\test.png";
    try (FileInputStream fis = new FileInputStream(new File(fp));
            BufferedInputStream bis = new BufferedInputStream(fis)) {
        BufferedImage img = ImageIO.read(bis);
        final int w = img.getWidth(null);
        final int h = img.getHeight(null);
    }