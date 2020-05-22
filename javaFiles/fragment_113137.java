/**
 * Retrieve the specified Print Service; will return null if not found.
 * @return
 */
public static PrintService findPrintService(String printerName) {

    PrintService service = null;

    // Get array of all print services - sort order NOT GUARANTEED!
    PrintService[] services = PrinterJob.lookupPrintServices();

    // Retrieve specified print service from the array
    for (int index = 0; service == null && index < services.length; index++) {

        if (services[index].getName().equalsIgnoreCase(printerName)) {

            service = services[index];
        }
    }

    // Return the print service
    return service;
}

/**
 * Retrieve a PrinterJob instance set with the PrinterService using the printerName.
 * 
 * @return
 * @throws Exception IllegalStateException if expected printer is not found.
 */
public static PrinterJob findPrinterJob(String printerName) throws Exception {

    // Retrieve the Printer Service
    PrintService printService = PrintUtility.findPrintService(printerName);

    // Validate the Printer Service
    if (printService == null) {

        throw new IllegalStateException("Unrecognized Printer Service \"" + printerName + '"');
    }

    // Obtain a Printer Job instance.
    PrinterJob printerJob = PrinterJob.getPrinterJob();

    // Set the Print Service.
    printerJob.setPrintService(printService);

    // Return Print Job
    return printerJob;
}

/**
 * Printer list does not necessarily refresh if you change the list of 
 * printers within the O/S; you can run this to refresh if necessary.
 */
public static void refreshSystemPrinterList() {

    Class[] classes = PrintServiceLookup.class.getDeclaredClasses();

    for (int i = 0; i < classes.length; i++) {

        if ("javax.print.PrintServiceLookup$Services".equals(classes[i].getName())) {

            sun.awt.AppContext.getAppContext().remove(classes[i]);
            break;
        }
    }
}