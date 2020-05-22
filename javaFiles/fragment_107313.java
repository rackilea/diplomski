public void merge (String assetFileName)
{
    PDFMergerUtility mergerUtility = new PDFMergerUtility();
    PDDocument srcDoc = PDDocument.load(PDFBoxResourceLoader.getStream(assetFileName));
    PDDocument dstDoc = prerparePdfToAppend();
    mergerUtility.appendDocument(dstDoc, srcDoc);
    dstDoc.save(destStream);
    srcDoc.close();
    dstDoc.close();
}