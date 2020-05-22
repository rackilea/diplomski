public void manipulatePdf(String src, String dest)
    throws IOException, DocumentException {
    PdfReader reader = new PdfReader(src);
    PdfStamper stamper = new PdfStamper(reader,
            new FileOutputStream(dest));
    AcroFields form = stamper.getAcroFields();
    XfaForm xfa = form.getXfa();
    xfa.fillXfaForm(new FileInputStream(XML));
    stamper.close();
    reader.close();
}