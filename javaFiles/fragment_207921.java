URI printerURI = new URI("ipp://SERVER:631/printers/PRINTER_NAME");
IppPrintService svc = new IppPrintService(printerURI);
InputStream stream = new BufferedInputStream(new FileInputStream("image.epl"));
DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
Doc myDoc = new SimpleDoc(stream, flavor, null);
DocPrintJob job = svc.createPrintJob();
job.print(myDoc, null);