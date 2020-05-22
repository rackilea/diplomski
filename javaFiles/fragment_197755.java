Barcode b = BarcodeFactory.createCode128("Hello");
b.setResolution(72);

.
.
.

public static class PrintToGraphics implements Printable {

    private Barcode b;

    private PrintToGraphics(Barcode b) {

        this.b = b;

    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {

        int result = NO_SUCH_PAGE;
        if (pageIndex == 0) {

            result = PAGE_EXISTS;

            int x = (int)pageFormat.getImageableX();
            int y = (int)pageFormat.getImageableY();

            int width = (int)pageFormat.getImageableWidth();
            int height = (int)pageFormat.getImageableHeight();

            graphics.translate(x, y);
            try {
                b.draw((Graphics2D)graphics, 0, 0);
            } catch (OutputException ex) {

                ex.printStackTrace();

            }

        }

        return result;

    }

}