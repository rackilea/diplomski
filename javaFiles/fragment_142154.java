public static void main(String args[]) throws IOException {
    InputStream pdfIs = //load your PDF
    RandomAccessBufferedFileInputStream rbfi = new RandomAccessBufferedFileInputStream(pdfIs);

    PDFParser parser = new PDFParser(rbfi);
    parser.parse();
    try (COSDocument cosDoc = parser.getDocument()) {
        PDFTextStripper pdfStripper = new PDFTextStripper();
        PDDocument pdDoc = new PDDocument(cosDoc);
        String parsedText = pdfStripper.getText(pdDoc);
        //System.out.println("Full text"+parsedText);

        for (int i = 0; i < parsedText.length(); i++) {
            if('☒'==parsedText.charAt(i)) {
                System.out.println("Found a checked box at index "+i);
                System.out.println("\\u" + Integer.toHexString(parsedText.charAt(i) | 0x10000).substring(1));
            }
            else if('☐'==parsedText.charAt(i)) {
                System.out.println("Found an unchecked box at index "+i);
                System.out.println("\\u" + Integer.toHexString(parsedText.charAt(i) | 0x10000).substring(1));
            }
            //else {//skip}
        }            
    }
}