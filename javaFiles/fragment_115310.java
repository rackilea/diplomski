public static void main(String[] args) throws IOException {
        XWPFDocument document = new XWPFDocument();

        XWPFTable tableOne = document.createTable();
        XWPFTableRow tableOneRowOne = tableOne.getRow(0);
        tableOneRowOne.getCell(0).setText("Header1");
        tableOneRowOne.addNewTableCell().setText("header2");
        XWPFTableRow tableOneRowTwo = tableOne.createRow();
        tableOneRowTwo.getCell(0).setText("Data1");
        tableOneRowTwo.getCell(1).setText("Data2");
        FileOutputStream outStream = new FileOutputStream("test.doc");
        document.write(outStream);
        outStream.close();
    }