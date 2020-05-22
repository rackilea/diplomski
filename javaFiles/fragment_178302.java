private static PdfPCell CreateCell(String text, BaseColor backgroundColor) {
    PdfPCell c = new PdfPCell(new Phrase(text));
    c.setBackgroundColor( backgroundColor );
    c.setPadding( 20 );
    c.setBorder( 0 );

    return c;
}