Document document = new Document(PageSize.A4);
String filename = ""; // Set the relative path and name for the output file
PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(filename));
document.open();
// Fix the path to the font if needed
BaseFont bf = BaseFont.createFont("c:/windows/fonts/arial.ttf", BaseFont.IDENTITY_H, true);
Font font = new Font(bf, 14);
ColumnText column = new ColumnText(writer.getDirectContent());
column.setSimpleColumn(36, 770, 569, 36);
column.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
String text = "הטקסט שלך בעברית"; // Your text in hebrew
column.addElement(new Paragraph(text, font));
column.go();
document.close();