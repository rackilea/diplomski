Font f = new Font(FontFamily.HELVETICA, 8.5f, Font.BOLD, BaseColor.WHITE);
    Chunk c = new Chunk("FOR EMPLOYMENT WITH XXXX YYYY XXXXX", f);

    PdfPTable table = new PdfPTable(1);
    PdfPCell cell = new PdfPCell(new Phrase(c));

    cell.setBackgroundColor(BaseColor.BLACK);
    table.addCell(cell);
    table.setWidthPercentage(100);

    document.add(table);
    document.close();