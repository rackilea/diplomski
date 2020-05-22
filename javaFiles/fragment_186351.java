...
String firstString="<table><tr><td>First Page</td></tr></table>" ;
String secondString="<table><tr><td>Second Page</td></tr></table>" ;
ByteArrayInputStream is = new ByteArrayInputStream(firstString.getBytes());
worker.parseXHtml(pdfWriter, doc, is);
doc.newPage();
is = new ByteArrayInputStream(secondString.getBytes());
worker.parseXHtml(pdfWriter, doc, is);
doc.close();
fos.close();