private void saveScreenshot() {
    // read current buffer
    FloatBuffer imageData = BufferUtils.createFloatBuffer(WIDTH * HEIGHT * 3); 
    GL11.glReadPixels(
        0, 0, WIDTH, HEIGHT, GL11.GL_RGB, GL11.GL_FLOAT, imageData
    );
    imageData.rewind();

    // fill rgbArray for BufferedImage
    int[] rgbArray = new int[WIDTH * HEIGHT];
    for(int y = 0; y < HEIGHT; ++y) {
        for(int x = 0; x < WIDTH; ++x) {
            int r = (int)(imageData.get() * 255) << 16;
            int g = (int)(imageData.get() * 255) << 8;
            int b = (int)(imageData.get() * 255);
            int i = ((HEIGHT - 1) - y) * WIDTH + x;
            rgbArray[i] = r + g + b;
        }
    }

    // create and save image
    BufferedImage image = new BufferedImage(
         WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB
    );
    image.setRGB(0, 0, WIDTH, HEIGHT, rgbArray, 0, WIDTH);
    File outputfile = getNextScreenFile();
    try {
        ImageIO.write(image, "png", outputfile);
    } catch (IOException e) {
        e.printStackTrace();
        System.err.println("Can not save screenshot!");
    }
}

private File getNextScreenFile() {
    // create image name
    String fileName = "screenshot_" + getSystemTime(false);
    File imageToSave = new File(fileName + ".png");

    // check for duplicates
    int duplicate = 0;
    while(imageToSave.exists()) {
        imageToSave = new File(fileName + "_" + ++duplicate + ".png");
    }

    return imageToSave;
}

// format the time
public static String getSystemTime(boolean getTimeOnly) {
    SimpleDateFormat dateFormat = new SimpleDateFormat(
      getTimeOnly?"HH-mm-ss":"yyyy-MM-dd'T'HH-mm-ss"
    );
    return dateFormat.format(new Date());
}