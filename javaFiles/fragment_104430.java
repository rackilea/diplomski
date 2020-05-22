public static PdfPCell createTextCell(String text) throws DocumentException, IOException {
    PdfPCell cell = new PdfPCell();
    Paragraph p = new Paragraph(text);
    p.setAlignment(Element.ALIGN_RIGHT);
    cell.addElement(p);
    cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
    cell.setBorder(Rectangle.NO_BORDER);
    return cell;
}