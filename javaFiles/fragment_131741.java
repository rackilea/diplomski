PdfContentByte cb = writer.getDirectContent();
float entireHeight = _numberOfPages * _pageHeight;
PdfTemplate hugeTempl = cb.createTemplate( 0, -entireHeight, pageWidth, _pageHeight );
g2 = hugeTempl.createGraphics(0, -entireHeight, _pageWidth, _pageHeight ); 
draw(g2);
g2.dispose();

for (int curPg = 0; curPg < _numberOfPages; ++curPg) {
  cb.addTemplateSimple( hugeTempl, 0, -_pageHeight * curPg );

  document.newPage();
}