Paragraph p = new Paragraph()
        .add("Be prepared to read a story about a London lawyer "
        + "named Gabriel John Utterson who investigates strange "
        + "occurrences between his old friend, Dr. Henry Jekyll, "
        + "and the evil Edward Hyde.");
MyParagraphRenderer renderer = new MyParagraphRenderer(p);
p.setNextRenderer(renderer);
document.add(p);