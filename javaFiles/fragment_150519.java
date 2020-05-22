public static void main(String[] args) throws IOException {
    XWPFDocument doc = new XWPFDocument();
    FileOutputStream out = new FileOutputStream(new File(FILENAME));

    XWPFParagraph para = doc.createParagraph();
    XWPFRun run = para.createRun();

    //table
    XWPFTable table = doc.createTable();
    table.setCellMargins(0, 500, 0, 500); //set margins here

    //rows
    XWPFTableRow row1 = table.getRow(0);
    row1.getCell(0).setText("Hello1");
    row1.addNewTableCell().setText("Hello2");
    row1.addNewTableCell().setText("Hello3");

    XWPFTableRow row2 = table.createRow();
    row2.getCell(0).setText("Hello4");
    row2.getCell(1).setText("Hello5");
    row2.getCell(2).setText("Hello6");

    doc.write(out);
    out.close();
    doc.close();
}