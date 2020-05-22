for (int i = 0 ; i < originalReader.getNumberOfPages(); ) {
    [...]
    if (pdfTatoueur != null) {

        PdfImportedPage fondDePage = copy.getImportedPage(fdpReader, 1);

        [...]
        directContent.addTemplate(fondDePage, markScale, 0, 0, markScale, hTrans, vTrans );
    }

    [...]
}