public static void main(String[] args) throws DocumentException, IOException{
    Document document = new Document(PageSize.A4, 50, 50, 70, 70);

        PdfWriter writer = PdfWriter.getInstance(document,
                new FileOutputStream("C:/pdfwithfooter.pdf"));
        document.open();

        document.add(new Paragraph(
                "Hello Body of the PDF"));

        /** Format Font **/
        Font fontFooter = new Font(FontFactory.getFont(
                FontFactory.HELVETICA, 6));

        /**
         * Format Table Cell Borders
         */
        // cell.disableBorderSide(Rectangle.BOX);
        Rectangle page = document.getPageSize();
        PdfPTable foot = new PdfPTable(4);
        PdfPCell footCell = new PdfPCell(new Phrase(
                "OUR DOCUMENT'S LEGEND", FontFactory.getFont(
                        FontFactory.HELVETICA, 6, Font.BOLDITALIC)));
        footCell.setColspan(2);
        foot.addCell(footCell);
        footCell = new PdfPCell(new Phrase(""));
        footCell.setColspan(2);
        foot.addCell(footCell);

        // 1st row
        footCell = new PdfPCell(new Phrase("COX - COX", fontFooter));
        footCell.setPaddingLeft(15);
        foot.addCell(footCell);
        footCell = new PdfPCell(new Phrase("EQ - Equipment", fontFooter));
        footCell.setPaddingLeft(15);
        foot.addCell(footCell);
        footCell = new PdfPCell(new Phrase("OUT-XYZ - Out XXXXXXXXXXXXX",
                fontFooter));
        footCell.setPaddingLeft(15);
        foot.addCell(footCell);
        footCell = new PdfPCell(new Phrase(
                "ADJ-XX - Adjustment on XXXXXX XXXX", fontFooter));
        footCell.setPaddingLeft(15);
        foot.addCell(footCell);
        // 2nd row
        footCell = new PdfPCell(new Phrase("EB - Electric Bills",
                fontFooter));
        footCell.setPaddingLeft(15);
        foot.addCell(footCell);
        footCell = new PdfPCell(new Phrase("T-BB - Transfer to Big Boat",
                fontFooter));
        footCell.setPaddingLeft(15);
        foot.addCell(footCell);
        footCell = new PdfPCell(new Phrase("T-XXXX - Transfer to XXXX",
                fontFooter));
        footCell.setPaddingLeft(15);
        foot.addCell(footCell);
        footCell = new PdfPCell(new Phrase("GX - Get XXXXXX", fontFooter));
        footCell.setPaddingLeft(15);
        foot.addCell(footCell);
        // 3rd row
        footCell = new PdfPCell(new Phrase(
                "EXCEPTIONS - Invalid X Y VALUES", fontFooter));
        footCell.setPaddingLeft(15);
        foot.addCell(footCell);
        footCell = new PdfPCell(new Phrase("R XX - Removal of XX",
                fontFooter));
        footCell.setPaddingLeft(15);
        foot.addCell(footCell);
        footCell = new PdfPCell(new Phrase("T-X - Transfer of XXXX",
                fontFooter));
        footCell.setPaddingLeft(15);
        foot.addCell(footCell);
        footCell = new PdfPCell(new Phrase(
                "T-LX - Transfer of Leased XXXX", fontFooter));
        footCell.setPaddingLeft(15);
        foot.addCell(footCell);
        // 4th row
        footCell = new PdfPCell(new Phrase("LX - Leased XXXX", fontFooter));
        footCell.setPaddingLeft(15);
        foot.addCell(footCell);
        footCell = new PdfPCell(new Phrase(
                "T-TX - Transfer to TREE XXXXXXX", fontFooter));
        footCell.setPaddingLeft(15);
        foot.addCell(footCell);
        footCell = new PdfPCell(new Phrase(
                "Adj-XXX - Adjustment Some Value",
                fontFooter));
        footCell.setPaddingLeft(15);
        footCell.setColspan(2);
        foot.addCell(footCell);

        foot.setTotalWidth(page.width() - document.leftMargin()
                - document.rightMargin());
        foot.writeSelectedRows(0, -1, document.leftMargin(),
                document.bottomMargin(), writer.getDirectContent());

        document.close();

}