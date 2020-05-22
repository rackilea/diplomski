Paragraph p = new Paragraph("This line will be underlined with a dotted line.");
DottedLineSeparator dottedline = new DottedLineSeparator();
dottedline.setOffset(-2);
dottedline.setGap(2f);
p.add(dottedline);
document.add(p);