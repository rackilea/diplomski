pdfDocument.setFlushUnusedObjects(true);

PdfLiteral obj = new PdfLiteral("HelloWorld");
PdfArray arr = new PdfArray();
arr.add(obj);
arr.makeIndirect(pdfDocument);