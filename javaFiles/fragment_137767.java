MyTextExtractionStrategy strategy = new MyTextExtractionStrategy();
for (int i=1; i<= reader.getNumberOfPages(); i++) {
    String rawText = PdfTextExtractor.getTextFromPage(reader, i, strategy);
    String tabulatedText = strategy.getTabulatedText();
    System.out.println(text);
}