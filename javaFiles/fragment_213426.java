public class PrintDocs implements Printable {
    private static final int pageHeight = 842;
    private BufferedImage incomingImage;
    private int pagePrintCount = 0;

    public PrintDocs(BufferedImage incomingImage) {
        this.incomingImage = incomingImage;
    }

    public void PrintImage() {
        HashPrintRequestAttributeSet attr = new HashPrintRequestAttributeSet();
        attr.add(new MediaPrintableArea(0f, 0f, incomingImage.getWidth() / 72f, incomingImage.getHeight() / 72f,
                MediaPrintableArea.INCH));

        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        PageFormat pf = job.pageDialog(job.defaultPage());
        boolean ok = job.printDialog();

        if (ok) {

            try {
                job.print(attr);
            } catch (PrinterException ex) {
                System.out.println("The job did not successfully complete");
                ex.printStackTrace();
            }

        }

    }

    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {

        System.out.println("print called for page="+page+", call count="+pagePrintCount++);

        /*
         * User (0,0 is typacally outside the imageable area, so we must
         * translate by the X and Y values in the PageFormatz to avoid clipping
         */

        if (page*pageHeight < incomingImage.getHeight()) {
            Graphics2D g2d = (Graphics2D) g;

            g2d.translate(pf.getImageableX() - 1.0, pf.getImageableY() - 1.0);

            /* Now we perform out rendering */

            g.drawImage(incomingImage, 0, 0, 595, pageHeight, 0, page*pageHeight, 595, pageHeight*(page+1), null);

            return PAGE_EXISTS;
        }
        return NO_SUCH_PAGE;
    }
}