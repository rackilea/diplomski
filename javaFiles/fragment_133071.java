PrinterJob printerJob = null;
try {
    if (System.getProperty("java.awt.printerjob").equals("sun.awt.windows.WPrinterJob")) {
        // WPrinterJob sends crappy GIF images to the printer, and everything looks all blocky
        // try to get an instance of a PSPrinterJob instead
        printerJob = (PrinterJob) Class.forName("sun.print.PSPrinterJob").newInstance();
    }
} catch (Throwable e1) {
    log.log(Level.SEVERE, "Could not instaniate sun.print.PSPrinterJob", e1);
}
if (printerJob == null) {
      printerJob = PrinterJob.getPrinterJob();
}