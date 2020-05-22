PDDocument samplePdf = null;
try {
    samplePdf = PDDocument.load(PDF_PATH);
    PDPage page = (PDPage) samplePdf.getDocumentCatalog().getAllPages().get(0); 

    for(int i = 0; i < COPIES; i++) {
        samplePdf.importPage(page);
    }

    samplePdf.save(SAVE_PATH); //$NON-NLS-1$

} catch (IOException e) {
    e.printStackTrace();
} catch (COSVisitorException e) {
    e.printStackTrace();
}