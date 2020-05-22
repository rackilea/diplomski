DefaultTableModel model = new DefaultTableModel(0, 10);
for (int row = 0; row < 400; row++) {
    Object[] values = new Object[10];
    for (int col = 0; col < 10; col++) {
        values[col] = ((char) ('A' + col)) + "x" + row;
    }
    model.addRow(values);
}

JTable table = new JTable(model);
table.setSize(table.getPreferredSize());

JTableHeader tableHeader = table.getTableHeader();
tableHeader.setSize(tableHeader.getPreferredSize());

Document doc = new Document(new Rectangle(1350, 1450));
PdfDestination pdfDest = new PdfDestination(PdfDestination.XYZ, 0, 800, 0.50f);
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
java.util.Date date = new java.util.Date();
String generatedDate = formatter.format(date);

Paper paper = new Paper();
paper.setSize(1350, 1450);
paper.setImageableArea(10, 10, 1350 - 20, 1450 - 20);

PageFormat pf = new PageFormat();
pf.setPaper(paper);

Printable printable = table.getPrintable(JTable.PrintMode.NORMAL, null, null);
try {

    PdfWriter writer;
    writer = PdfWriter.getInstance(doc, new FileOutputStream("test.pdf"));
    writer.setViewerPreferences(PdfWriter.PageLayoutSinglePage);

    doc.open();

    // Use this to "test" if there is page
    // available for printing, otherwise it prints
    // a empty page and I can't figure out
    // how to remove it :P
    BufferedImage img = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = img.createGraphics();

    Font f = new Font(Font.TIMES_ROMAN, 12f);
    int page = 0;
    int result = Printable.NO_SUCH_PAGE;
    PdfContentByte cb = writer.getDirectContent();
    do {

        result = printable.print(g, pf, page);

        if (result == Printable.PAGE_EXISTS) {

            cb.saveState();
            Graphics2D g2 = cb.createGraphics(1350, 1450);

            System.out.println(page);
            result = printable.print(g2, pf, page);

            g2.dispose();
            cb.restoreState();

            doc.add(new Paragraph("REPORTS", f));
            doc.add(new Paragraph("Document Generated On - " + generatedDate, f));

            page++;
            doc.newPage();

        }

    } while (result == Printable.PAGE_EXISTS);
    g.dispose();

} catch (DocumentException | PrinterException | FileNotFoundException e) {
    e.printStackTrace();
} finally {
    doc.close();
}