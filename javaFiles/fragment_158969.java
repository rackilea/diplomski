GC gc = new GC(text);

gc.setFont(text.getFont());

FontMetrics fontMetrics = gc.getFontMetrics();

data.widthHint = fontMetrics.getAverageCharWidth() * chars;

gc.dispose();