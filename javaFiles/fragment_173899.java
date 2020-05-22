PrintService prnSvc = null;

    /* locate a print service that can handle it */
    PrintService[] pservices =
            PrintServiceLookup.lookupPrintServices(null, null);
    if (pservices.length > 0) {
        int ii=0;
        while(ii < pservices.length)
        {
            System.out.println("Named Printer found: "+pservices[ii].getName());
            if (pservices[ii].getName().endsWith("YourPrinterName")) {
                prnSvc = pservices[ii];
                System.out.println("Named Printer selected: " + pservices[ii].getName() + "*");
                break;
            }
          ii++;
        }