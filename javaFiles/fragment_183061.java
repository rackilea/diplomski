public void ReadPDF() throws Exception {
    URL TestURL = new URL("http://www.axmag.com/download/pdfurl-guide.pdf");

    BufferedInputStream TestFile = new BufferedInputStream(TestURL.openStream());
    PDFParser TestPDF = new PDFParser(TestFile);
    TestPDF.parse();
    String TestText = new PDFTextStripper().getText(TestPDF.getPDDocument());

    Assert.assertTrue(TestText.contains("Open the setting.xml, you can see it is like this"));

    }