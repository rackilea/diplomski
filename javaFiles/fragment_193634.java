PDDocument document = PDDocument.load(SOURCE);

for (int pageNr = 0; pageNr < document.getNumberOfPages(); pageNr++)
{
    PDPage page = document.getPage(pageNr);
    PDResources resources = page.getResources();
    removeToUnicodeMaps(resources);
}

PDFTextStripper stripper = new PDFTextStripper();
String text = stripper.getText(document);