ColumnText ct = new ColumnText(stamper.getOverContent(i));
ct.setSimpleColumn(new Rectangle(30, 600, 523, 720));
Chunk c = new Chunk("Underlined text");
c.setUnderline(1.5f, -1);
ct.addElement(new Paragraph(c));
ct.go();