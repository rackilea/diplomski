if (isPasswordPresent) {
    documentFinal = PDDocument.load(new File(PDFpath), pdfPasswordForEncryption);
} else {
    documentFinal = PDDocument.load(new File(PDFpath));
}

for (int i = 1; i < 4; i++) {
    FileInputStream image2 = new FileInputStream(tickImagePath);

    PDSignature pdsignature = new PDSignature();

    [...]

    try {
        [...]

        if (visibleSignatureProp.isVisualSignEnabled()) {
            [...]
            documentFinal.addSignature(pdsignature, this, this.options);
        } else {
            documentFinal.addSignature(pdsignature, this);
        }
    } catch (Exception e) {
        System.out.println("Inside getSignOnPdf sub exception block at addSignature:" + e + "error :" + e.getMessage());
        e.printStackTrace();
    }
}

synchronized (this) {
    [...]
    saveIncrementalForSign(saveIncrementalSignObject);
}