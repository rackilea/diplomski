Barcode b = BarcodeFactory.createCode128("Hello");
b.setResolution(72);

File f = new File("mybarcode.png");
// Let the barcode image handler do the hard work
BarcodeImageHandler.savePNG(b, f);

.
.
.

public static class PrintFromFile implements Printable {

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {

        int result = NO_SUCH_PAGE;
        if (pageIndex == 0) {

            graphics.translate((int)pageFormat.getImageableX(), (int)pageFormat.getImageableY());

            result = PAGE_EXISTS;

            try {

                // You may want to rescale the image to better fit the label??
                BufferedImage read = ImageIO.read(new File("mybarcode.png"));
                graphics.drawImage(read, 0, 0, null);

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

        return result;

    }

}