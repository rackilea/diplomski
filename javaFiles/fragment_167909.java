public class ImageCompressor {
    public void compress() throws IOException {
        File infile = new File("Y:\\img\\star.jpg");
        File outfile = new File("Y:\\img\\star_compressed.jpg");

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
                infile));
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(outfile));

        SeekableStream s = SeekableStream.wrapInputStream(bis, true);

        RenderedOp image = JAI.create("stream", s);
        ((OpImage) image.getRendering()).setTileCache(null);

        RenderingHints qualityHints = new RenderingHints(
                RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        RenderedOp resizedImage = JAI.create("SubsampleAverage", image, 0.9,
                0.9, qualityHints);

        JAI.create("encode", resizedImage, bos, "JPEG", null);

    }

    public static void main(String[] args) throws IOException {

        new ImageCompressor().compress();
    }
}