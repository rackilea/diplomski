public class MyPSDocumentGraphics2D extends PSDocumentGraphics2D {
    public MyPSDocumentGraphics2D(PSDocumentGraphics2D psDocumentGraphics2D) {
        super(psDocumentGraphics2D);
    }

    public MyPSDocumentGraphics2D(boolean b, OutputStream outputStream, int i, int i1) throws IOException {
        super(b, outputStream, i, i1);
    }

    public MyPSDocumentGraphics2D(boolean b) {
        super(b);
    }

    public void setDimension(int width, int height) {
        this.width = width;
        this.height = height;
    }
}