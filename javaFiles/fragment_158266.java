/**
 * http://stackoverflow.com/questions/5338423/print-a-image-with-actual-size
 * -in-java
 * 
 * @param graphicFile
 */
public void printG(File graphicFile) {
    final Image img = new ImageIcon(graphicFile.getAbsolutePath())
            .getImage();
    PrinterJob printJob = PrinterJob.getPrinterJob();
    Printable printable = new Printable() {
        public int print(Graphics graphics, PageFormat pageFormat,
                int pageIndex) throws PrinterException {
            if (pageIndex != 0) {
                return NO_SUCH_PAGE;
            }
            graphics.drawImage(img, 0, 0, img.getWidth(null),
                    img.getHeight(null), null);
            return PAGE_EXISTS;
        }
    };
    printJob.setPrintable(printable, getPageFormat());
    if (printJob.printDialog()) {
        try {
            printJob.print();
        } catch (Exception prt) {
            handle(prt);
        }
    }
}