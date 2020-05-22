public void manipulatePdf(String src, String dest) throws DocumentException, IOException {
    PdfReader reader = new PdfReader(src);
    Rectangle pagesize = reader.getPageSize(1);
    PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
    AcroFields form = stamper.getAcroFields();
    form.setField("Name", "Jennifer");
    form.setField("Company", "iText's next customer");
    form.setField("Country", "No Man's Land");
    PdfPTable table = new PdfPTable(2);
    table.addCell("#");
    table.addCell("description");
    table.setHeaderRows(1);
    table.setWidths(new int[]{ 1, 15 });
    for (int i = 1; i <= 150; i++) {
        table.addCell(String.valueOf(i));
        table.addCell("test " + i);
    }
    ColumnText column = new ColumnText(stamper.getOverContent(1));
    Rectangle rectPage1 = new Rectangle(36, 36, 559, 540);
    column.setSimpleColumn(rectPage1);
    column.addElement(table);
    int pagecount = 1;
    Rectangle rectPage2 = new Rectangle(36, 36, 559, 806);
    int status = column.go();
    while (ColumnText.hasMoreText(status)) {
        status = triggerNewPage(stamper, pagesize, column, rectPage2, ++pagecount);
    }
    stamper.setFormFlattening(true);
    stamper.close();
    reader.close();
}

public int triggerNewPage(PdfStamper stamper, Rectangle pagesize, ColumnText column, Rectangle rect, int pagecount) throws DocumentException {
    stamper.insertPage(pagecount, pagesize);
    PdfContentByte canvas = stamper.getOverContent(pagecount);
    column.setCanvas(canvas);
    column.setSimpleColumn(rect);
    return column.go();
}