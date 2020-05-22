Rectangle rect = new Rectangle(0, 780, 494, 820);
rect.setBorder(Rectangle.BOX);
rect.setBorderWidth(1);
rect.setBackgroundColor(BaseColor.GRAY);
rect.setBorderColor(BaseColor.GREEN);
canvas.rectangle(rect);

ColumnText ct = new ColumnText(canvas);
ct.setSimpleColumn(rect);
Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
ct.addElement(new Paragraph("Your Text Goes here!! ", catFont));
ct.go();