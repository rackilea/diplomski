PdfWriter writer = new PdfCopy(document,new FileOutputStream("e:\\new1.pdf"));
document.open();
PdfImportedPage page; 
document.newPage(); 
for(int i=1; i<=n; i++) { 
  page = writer.getImportedPage(reader,i); 
  ((PdfCopy) writer).addPage(page); 
}