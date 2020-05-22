public static boolean printToPostScript(File file, Printable printable) {
    try {
        if(!file.exists()) {
            file.createNewFile();
        }

        PrinterJob job = PrinterJob.getPrinterJob();
        String mime = "application/postscript";
        FileOutputStream out = new FileOutputStream(file.getAbsolutePath());
        StreamPrintService printer;
        StreamPrintServiceFactory[] factories =
            PrinterJob.lookupStreamPrintServices(mime);

        if(factories.length > 0) {
                printer = factories[0].getPrintService(out);
                job.setPrintService(printer);
                job.setPrintable(printable);
                job.print();
        } else {
            System.out.println("No suitable print services");
            return false;
        }
    } catch(Exception e) {
        e.printStackTrace();
        return false;
    }

    return true;
}