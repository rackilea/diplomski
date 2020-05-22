FontSelector selector = new FontSelector();
Font f1 = FontFactory.getFont(FontFactory.TIMES_ROMAN, 12);
f1.setColor(BaseColor.BLUE);
Font f2 = FontFactory.getFont("MSung-Light",
    "UniCNS-UCS2-H", BaseFont.NOT_EMBEDDED);
f2.setColor(BaseColor.RED);
selector.addFont(f1);
selector.addFont(f2);
Phrase ph = selector.process(TEXT);