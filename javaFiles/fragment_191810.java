PDDocument document = PDDocument.load(resource);
PDFTextStripper stripper = new PDFTextStripper() {
    @Override
    protected void writeString(String text, List<TextPosition> textPositions) throws IOException {
        for (TextPosition textPosition : textPositions) {
            writeString(String.format("%s%s", textPosition.getUnicode(), Arrays.toString(textPosition.getCharacterCodes())));
        }
    }
};
//stripper.setSortByPosition(true);
String text = stripper.getText(document);

System.out.printf("\n*\n* singNepChar.pdf\n*\n%s\n", text);