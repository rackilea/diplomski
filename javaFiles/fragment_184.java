private void convert() {
    try {
        PDDocument pdf = PDDocument.load(new File(SOURCE_PDF));
        PDFDomTree parser = new PDFDomTree(PDFDomTreeConfig.createDefaultConfig());
        Writer output = new PrintWriter(TARGET_HTML, "UTF-8");
        parser.writeText(pdf, output);
        output.close();
        pdf.close();
    } catch (IOException | ParserConfigurationException e) {
        // Handle errors
    } 
}