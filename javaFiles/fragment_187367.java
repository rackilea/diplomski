private void openPDFDoc(final File pdfFile) throws Exception {
        File originalPDF = pdfFile;
        PDFParser parser = new PDFParser(new BufferedInputStream(new FileInputStream(
                originalPDF)));
        parser.parse();

        PDDocument originialPdfDoc = parser.getPDDocument();

        boolean isOriginalDocEncrypted = originialPdfDoc.isEncrypted();
        if (isOriginalDocEncrypted) {
            originialPdfDoc.openProtection(new StandardDecryptionMaterial("password"));
        }
    }