public class MyImageRenderListener implements RenderListener {

protected String path = "";
protected ArrayList<BufferedImage> bimg = new ArrayList<>();

/**
 * Creates a RenderListener that will look for images.
 */
public MyImageRenderListener(String path) {
    this.path = path;
}

public ArrayList<BufferedImage> getBimgArray() {
    return bimg;
}

/**
 * @see com.itextpdf.text.pdf.parser.RenderListener#renderImage(
 * com.itextpdf.text.pdf.parser.ImageRenderInfo)
 */
public void renderImage(ImageRenderInfo renderInfo) {
    try {

        PdfImageObject image = renderInfo.getImage();

        if (image == null) {
            return;
        }
        bimg.add(image.getBufferedImage());

    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
}