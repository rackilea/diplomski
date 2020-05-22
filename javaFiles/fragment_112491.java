java.awt.print.PrinterJob printJob = PrinterJob.getPrinterJob();
Button b = new Button("Print Dialog");
b.setOnAction(event -> {
    JFrame f = new JFrame();
    printJob.printDialog();
    // Stage will be blocked(non responsive) until the printDialog returns
});