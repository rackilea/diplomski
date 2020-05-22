private void fillXmlInPdf(File xmlFile, File inputPdf, File outputPdf) throws IOException, DocumentException, FileNotFoundException, CsmartException {
    PdfStamper stamper=null;
    try {
        PdfReader reader = new PdfReader(inputPdf.getAbsolutePath());
        stamper = new PdfStamper(reader, new FileOutputStream(outputPdf), '\0', true);
        AcroFields afields = stamper.getAcroFields();
        XfaForm xfa = afields.getXfa();
        xfa.fillXfaForm(new FileInputStream(xmlFile));
    } catch (Exception e) {
        e.printStackTrace();
    }finally {
        try {
            stamper.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}