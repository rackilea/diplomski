public void PrintReportToPrinterSection(JasperPrint jp, String pp) throws PrinterException {
try{

        // TODO Auto-generated method stub
        PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
        // printRequestAttributeSet.add(MediaSizeName.ISO_A4); //setting page size
        printRequestAttributeSet.add(new Copies(1));

        PrinterName printerName = new PrinterName(pp, null); //gets printer 

        PrintServiceAttributeSet printServiceAttributeSet = new HashPrintServiceAttributeSet();
        printServiceAttributeSet.add(printerName);

            PrinterJob printerJob = PrinterJob.getPrinterJob();
            PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
            PrintService selectedService = null;

            if(services.length != 0 || services != null)
            {
                for(PrintService service : services){
                    String existingPrinter = service.getName().toLowerCase();
            Object selectedPrinter = pp;
                    if(existingPrinter.equals(selectedPrinter))
                    {
                        selectedService = service;
                        break;
                    }
                }

                if(selectedService != null)
                {
                    printerJob.setPrintService(selectedService);
                    boolean printSucceed = JasperPrintManager.printReport(pp, false);
                }}
        JRPrintServiceExporter exporter = new JRPrintServiceExporter();

        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jp);
        exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, printRequestAttributeSet);
        exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, printServiceAttributeSet);
        exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
        exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
        exporter.exportReport();
} catch (JRException e) {
    System.out.println(e);
}
    }