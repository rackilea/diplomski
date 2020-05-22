public static void main(String[] args) throws IOException {
    FileInputStream in = new FileInputStream("test.pdf");
    Doc doc = new SimpleDoc(in, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
    PrintService service = PrintServiceLookup.lookupDefaultPrintService();

    try {
        service.createPrintJob().print(doc, null);
    } catch (PrintException e) {
        e.printStackTrace();
    }
}