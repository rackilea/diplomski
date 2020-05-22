public static final XMLOutputProcessor XMLOUTPUT = new AbstractXMLOutputProcessor() {
    @Override
    protected void printDeclaration(final Writer out, final FormatStack fstack) throws IOException {
        write(out, "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"no\"?> ");
        write(out, fstack.getLineSeparator());
    }
};