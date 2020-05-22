Font fontbold = new Font(BaseFont.createFont(BaseFont.HELVETICA_BOLD,
    BaseFont.WINANSI, BaseFont.NOT_EMBEDDED), 12);
Font fontregular = new Font(BaseFont.createFont(BaseFont.HELVETICA,
    BaseFont.WINANSI, BaseFont.NOT_EMBEDDED), 12);
Chunk header = new Chunk("Heading: ", fontbold);
Chunk content = new Chunk("this is a para now ...", fontregular);
Paragraph paragraph = new Paragraph();
paragraph.add(header);
paragraph.add(content);
document.add(paragraph);