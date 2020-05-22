String html ="<html><h1>Header</h1><p>A paragraph</p><p>Another Paragraph</p></html>";
String css = "h1 {color: red;}";
ElementList elementsList = XMLWorkerHelper.parseToElementList(html, css);

PdfReader reader = new PdfReader(resource);
PdfStamper stamper = new PdfStamper(reader, result);

Rectangle cropBox = reader.getCropBox(1);

PdfAnnotation annotation = stamper.getWriter().createAnnotation(cropBox, PdfName.FREETEXT);
PdfAppearance appearance = PdfAppearance.createAppearance(stamper.getWriter(), cropBox.getWidth(), cropBox.getHeight());

ColumnText ct = new ColumnText(appearance);
ct.setSimpleColumn(new Rectangle(cropBox.getWidth(), cropBox.getHeight()));
elementsList.forEach(element -> ct.addElement(element));
ct.go();

annotation.setAppearance(PdfAnnotation.APPEARANCE_NORMAL, appearance);
stamper.addAnnotation(annotation, 1);

stamper.close();
reader.close();