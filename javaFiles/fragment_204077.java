/*
 * CAPEC
 */
if (cve.getCapec().size() > 0) {
    Paragraph capec = new Paragraph(new Chunk("\nCAPEC", captionFont));
    PdfPTable table = new PdfPTable(2);
    table.setHeaderRows(1);
    table.setWidthPercentage(100);
    table.setTotalWidth(100);
    Paragraph capecs = new Paragraph(new Chunk("",normalFont));
    for (Capec capecTmp : cve.getCapec()) {
        table.addCell(createCell(capecTmp.getName()));
        //capecs.add("\n"+capecTmp.getName());
        //document.add(table);
    }
    document.add(capec);
    //document.add(capecs);
    document.add(table);
    document.add(Chunk.NEWLINE);
}