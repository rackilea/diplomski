Document mergePdfDoc = new Document();
    PdfCopy pdfCopy;
    boolean smartCopy = false;

    FileOutputStream newmergeOutStream = new FileOutputStream(new File("C:\\UpdateFile\\mergepath\\newmerged.pdf"));

    if(smartCopy)
        pdfCopy = new PdfSmartCopy(mergePdfDoc, newmergeOutStream);
    else
        pdfCopy = new PdfCopy(mergePdfDoc, newmergeOutStream);

    mergePdfDoc.open();

    PdfReader reader = new PdfReader(new FileInputStream(new File("C:\\UpdateFile\\mergepath\\updatetem.pdf")));
    pdfCopy.addDocument(reader);
    pdfCopy.freeReader(reader);

    PdfReader[] pdfReader = new PdfReader[userInfoFiles.length];

    for(int i=0; i<=userInfoFiles.length-1;i++) {
            pdfReader[i] = new PdfReader(userInfoFiles[i].getInputStream());
            pdfCopy.addDocument(pdfReader[i]);
            pdfCopy.freeReader(pdfReader[i]);
            pdfReader[i].close();
    }

    mergeOutStream.close();
    mergePdfDoc.close();
}