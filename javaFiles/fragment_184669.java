public void onEndPage(PdfWriter writer, Document document) {
    [...]

    //ajout du fond de page
    if (markReader != null) {
        [...]
        directContent.addTemplate(fondDePage, markScale, 0, 0, markScale, hTrans, vTrans );    
    }

    [...]
}