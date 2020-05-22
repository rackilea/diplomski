PdfReader reader = new PdfReader(resourceStream); 
PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("target/test-outputs/test-trimmed-stamper.pdf")); 

// Go through all pages 
int n = reader.getNumberOfPages(); 
for (int i = 1; i <= n; i++) 
{ 
    Rectangle pageSize = reader.getPageSize(i); 
    Rectangle rect = getOutputPageSize(pageSize, reader, i); 

    PdfDictionary page = reader.getPageN(i); 
    page.put(PdfName.CROPBOX, new PdfArray(new float[]{rect.getLeft(), rect.getBottom(), rect.getRight(), rect.getTop()})); 
    stamper.markUsed(page); 
} 
stamper.close();