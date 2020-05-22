BaseFont bf = BaseFont.createFont(
    "c:/windows/fonts/arialuni.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
Font font = new Font(bf, 20);
ColumnText column = new ColumnText(writer.getDirectContent());
column.setSimpleColumn(36, 730, 569, 36);
column.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
column.addElement(new Paragraph(
    "\u0627\u0644\u0645\u0648\u0642\u0639 \u0627\u0644\u0625\u0644\u0643\u062a\u0631\u0648\u0646\u064a", font));
column.go();