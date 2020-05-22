private void printCard() {

    PrinterJob printjob = PrinterJob.getPrinterJob();
    printjob.setJobName(" TESSCO CUSTOMER CARD ");

    Printable printable = new Printable() {

        public int print(Graphics pg, PageFormat pf, int pageNum) {

            if (pageNum > 0) {
                return Printable.NO_SUCH_PAGE;
            }

            Dimension size = jLayeredPane2.getSize();
            BufferedImage bufferedImage = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_RGB);

            jLayeredPane2.print(bufferedImage.getGraphics());

            Graphics2D g2 = (Graphics2D) pg;
            g2.translate(pf.getImageableX(), pf.getImageableY());
            g2.drawImage(bufferedImage, 0, 0, (int) pf.getWidth(), (int) pf.getHeight(), null);

            return Printable.PAGE_EXISTS;
        }
    };

    Paper paper = new Paper();
    paper.setImageableArea(0, 0, 153, 243);
    paper.setSize(243, 154);

    PageFormat format = new PageFormat();
    format.setPaper(paper);
    format.setOrientation(PageFormat.LANDSCAPE);

    printjob.setPrintable(printable, format);
    if (printjob.printDialog() == false)
        return;

    try {
        printjob.print();
    } catch (PrinterException ex) {
        System.out.println("NO PAGE FOUND." + ex);

    }
}