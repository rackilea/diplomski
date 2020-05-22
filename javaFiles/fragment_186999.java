public static void test() throws Exception
    {
        ByteArrayOutputStream printData = new ByteArrayOutputStream();

        printData.write(PrintClass.Emphasis);
        printData.write(PrintClass.DoubleSize);
        printData.write(PrintClass.Underline);
        printData.write("Hello".getBytes("CP437"));
        printData.write(PrintClass.CancelEmphasis);
        printData.write(PrintClass.ResetSize);
        printData.write(PrintClass.CancelUnderline);
        printData.write(GenerateReceiptBody().getBytes("CP437"));
        printData.write(PrintClass.Halfsize);
        printData.write(Constants.getFooter().getBytes("CP437"));
        printData.write(PrintClass.Cut);

        printBytes(printData.toByteArray());
    }

    public static void printBytes(final byte[] bytes) throws Exception
    {
        DocPrintJob job = PrintServiceLookup.lookupDefaultPrintService().createPrintJob();
        System.out.println(job + " <- printer");
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
        Doc doc = new SimpleDoc(bytes, flavor, null);
        job.print(doc, null);
    }