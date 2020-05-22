public final class GIFUtils {

private GIFUtils() {
}

public static List<BufferedImage> extractFrames(String filePath) throws IOException {
    return extractFrames(new File(filePath));
}

public static List<BufferedImage> extractFrames(File file) throws IOException {
    List<BufferedImage> imgs = new LinkedList<BufferedImage>();
    ImageReader reader = ImageIO.getImageReadersBySuffix("GIF").next();
    ImageInputStream in = null;
    try {
        in = ImageIO.createImageInputStream(new FileInputStream(file));
        reader.setInput(in);
        BufferedImage img = null;
        int count = reader.getNumImages(true);
        for(int i = 0; i < count; i++) {
            Node tree = reader.getImageMetadata(i).getAsTree("javax_imageio_gif_image_1.0");
            int x = Integer.valueOf(tree.getChildNodes().item(0).getAttributes()
                    .getNamedItem("imageLeftPosition").getNodeValue());
            int y = Integer.valueOf(tree.getChildNodes().item(0).getAttributes()
                    .getNamedItem("imageTopPosition").getNodeValue());
            BufferedImage image = reader.read(i);
            if(img == null) {
                img = new BufferedImage(image.getWidth() + x, image.getHeight() + y,
                        BufferedImage.TYPE_4BYTE_ABGR);
            }

            Graphics2D g = img.createGraphics();
            ImageUtils.setBestRenderHints(g);
            g.drawImage(image, x, y, null);
            imgs.add(ImageUtils.copy(img));
        }
    }
    finally {
        if(in != null) {
            in.close();
        }
    }
    return imgs;
}

public static void writeGif(List<BufferedImage> images, File gifFile, int millisForFrame)
        throws FileNotFoundException, IOException {
    BufferedImage firstImage = images.get(0);
    int type = firstImage.getType();

    ImageOutputStream output = new FileImageOutputStream(gifFile);

    // create a gif sequence with the type of the first image, 1 second
    // between frames, which loops continuously
    GifSequenceWriter writer = new GifSequenceWriter(output, type, 100, false);

    // write out the first image to our sequence...
    writer.writeToSequence(firstImage);
    for(int i = 1; i < images.size(); i++) {
        BufferedImage nextImage = images.get(i);
        writer.writeToSequence(nextImage);
    }

    writer.close();
    output.close();
}

public static Image createGif(List<BufferedImage> images, int millisForFrame) {
    AnimatedGifEncoder g = new AnimatedGifEncoder();
    ByteArrayOutputStream out = new ByteArrayOutputStream(5 * 1024 * 1024);
    g.start(out);
    g.setDelay(millisForFrame);
    g.setRepeat(1);
    for(BufferedImage i : images) {
        g.addFrame(i);
    }
    g.finish();
    byte[] bytes = out.toByteArray();
    return Toolkit.getDefaultToolkit().createImage(bytes);
}