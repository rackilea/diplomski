PrintService service = PrintServiceLookup.lookupDefaultPrintService();
    int count = 0;
    for (DocFlavor docFlavor : service.getSupportedDocFlavors()) {
        if (docFlavor.toString().contains("pdf")) {
            count++;
        }
    }
    if (count == 0) {
        System.err.println("PDF not supported by printer: " + service.getName());
        System.exit(1);
    } else {
        System.out.println("PDF is supported by printer: " + service.getName());
    }