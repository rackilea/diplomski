public BufferedImage loadImage(String filepath) {
    try {
        return ImageIO.read(new File(filepath));
    }
    catch (IOException e) {
    }
   return null;
}

background = loadImage(path);