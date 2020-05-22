static void print(Printable printable, PrintService service)
throws PrintException,
       IOException {

    Path outputFile = Files.createTempFile(
        Paths.get(System.getProperty("user.home")), null, ".xps");

    Doc doc = new SimpleDoc(printable,
        DocFlavor.SERVICE_FORMATTED.PRINTABLE, null);

    PrintRequestAttributeSet attributes =
        new HashPrintRequestAttributeSet();
    attributes.add(new Destination(outputFile.toUri()));

    DocPrintJob job = service.createPrintJob();
    job.print(doc, attributes);
}