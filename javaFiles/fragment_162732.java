try {
    URL url = new URL("http://www.worldweatheronline.com/images/wsymbols01_png_64/wsymbol_0001_sunny.png");
    BufferedImage bufferedImage = ImageIO.read(url);
    ImageIO.write(bufferedImage, "png", new FileOutputStream("/home/visruth/OutputImage.png"));// A file named OutputImage.png will be created in the location /home/visruth/
    } catch(Exception e) {
        e.printStackTrace();
    }