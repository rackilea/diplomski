private void printImage(Node node) {
    Printer printer = Printer.getDefaultPrinter();
    PageLayout pageLayout = printer.getDefaultPageLayout();

    // Printable area
    double pWidth = pageLayout.getPrintableWidth();
    double pHeight = pageLayout.getPrintableHeight();

    // Node's (Image) dimensions
    double nWidth = node.getBoundsInParent().getWidth();
    double nHeight = node.getBoundsInParent().getHeight();

    // How much space is left? Or is the image to big?
    double widthLeft = pWidth - nWidth;
    double heightLeft = pHeight - nHeight;

    // scale the image to fit the page in width, height or both
    double scale;

    if (widthLeft < heightLeft) scale = pWidth / nWidth;
    else scale = pHeight / nHeight;

    // preserve ratio (both values are the same)
    node.getTransforms().add(new Scale(scale, scale));

    PrinterJob job = PrinterJob.createPrinterJob();
    if (job != null) {
        boolean success = job.printPage(node);
        if (success) {
            System.out.println("PRINTING FINISHED");
            job.endJob();
        }
    }
}