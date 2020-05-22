final int rasterizedDpi = 203;
final PDDocument pdfDocument = PDDocument.load(data);
final PrinterJob job = PrinterJob.getPrinterJob();
final PDFPageable pageable = new PDFPageable(pdfDocument, Orientation.AUTO, false, rasterizedDpi);
job.setPageable(pageable);
job.print();