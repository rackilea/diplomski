public class MyPrintable implements Printable {

    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex < 5) {
            graphics.drawString("HELLO FRIEND", 100, 180);
            return PAGE_EXISTS;
        } else {
            return NO_SUCH_PAGE;
        }
    }

    public static void main(String[] args) {
        PrinterJob job = PrinterJob.getPrinterJob();
        PageFormat pf = job.defaultPage();
        pf.setOrientation(PageFormat.LANDSCAPE);
        job.setPrintable(new MyPrintable(), pf);

        boolean ok = job.printDialog();
        if (ok) {
            try {
                job.print();
            } catch (PrinterException ex) {
                /* The job did not successfully complete */
            }
        }
    }
}