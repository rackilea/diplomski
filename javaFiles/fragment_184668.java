private void init(File pdfDestination, File pdfTatoueur, String textFiligrane, String textMarquage) throws DocumentException, IOException{
    [...]
    if (pdfTatoueur != null) {
        markReader = new PdfReader(pdfTatoueur.getAbsolutePath());
        fondDePage = writer.getImportedPage(markReader, 1);
    }
    [...]
}