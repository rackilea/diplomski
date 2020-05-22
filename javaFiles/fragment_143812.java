public void run() {
    try {
        Document document = new Document(PageSize.LETTER, 10.0f, 10.0f, 36.0f, 36.0f);
        PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("test.pdf"));
        document.open();

        PdfPTable outerTable = new PdfPTable(1);
        outerTable.setWidthPercentage(100.0f);

        PdfPCell cell = new PdfPCell();
        cell.setMinimumHeight(document.getPageSize().getHeight() - 36.0f - 36.0f);
        cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
        cell.addElement(createTable());

        outerTable.addCell(cell);
        document.add(outerTable);
        document.newPage();
        document.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

}

public PdfPTable leftTable() {
    PdfPTable table = new PdfPTable(1);
    for (int i = 0; i < 50; i++) {
        table.addCell("Cell: " + i);
    }
    return table;
}

public PdfPTable middleTable() {
    PdfPTable table = new PdfPTable(1);
    for (int i = 0; i < 10; i++) {
        table.addCell("Cell: " + i);
    }
    return table;
}

public PdfPTable rightTable() {
    PdfPTable table = new PdfPTable(1);
    for (int i = 0; i < 100; i++) {
        table.addCell("Cell: " + i);
    }
    return table;
}

public PdfPTable createTable() {
    PdfPTable table = new PdfPTable(3);

    table.getDefaultCell().setVerticalAlignment(Element.ALIGN_BOTTOM);
    table.addCell(leftTable());
    table.addCell(middleTable());
    table.addCell(rightTable());

    return table;
}