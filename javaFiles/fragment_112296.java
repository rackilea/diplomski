OutputStream os = response.getOutputStream();
PdfDocument result = new PdfDocument(new PdfWriter(os));
for (PdfDocument pdfDoc : listPDF) {
    pdfDoc.initializeOutlines();
    List<PdfPage> list = pdfDoc.copyPagesTo(1, pdfDoc.getNumberOfPages(), result);          
    pdfDoc.close();
}
result.close();