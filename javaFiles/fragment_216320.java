public class PrintApp  {

    public static void print() {
            JasperPrint jasperPrint = getJasperPrint();
            String selectedPrinter = AllPrinter.getDepartmentPrinter("Admin");

            PrinterJob printerJob = PrinterJob.getPrinterJob();
            PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
            PrintService selectedService = null;

            if(services.length != 0 || services != null)
            {
                for(PrintService service : services){
                    String existingPrinter = service.getName().toLowerCase();
                    if(existingPrinter.equals(selectedPrinter))
                    {
                        selectedService = service;
                        break;
                    }
                }

                if(selectedService != null)
                {
                    printerJob.setPrintService(selectedService);
                    boolean printSucceed = JasperPrintManager.printReport(mainPrint, false);
                }
    }

    private static JasperPrint getJasperPrint() {
            return JasperPrinterCreator.getJasperprint();
    }
}