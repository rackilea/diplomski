PdfDocument sourceDocument = new PdfDocument(new PdfReader(filename));

PdfMerger resultDocument = new PdfMerger(new PdfDocument(new PdfWriter(resultFile)));
resultDocument.merge(sourceDocument, fromPage, toPage);
resultDocument.close();
sourceDocument.close();