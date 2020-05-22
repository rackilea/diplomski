int width = (fontMetrics.charWidth('0') * digits) + numberX + 7;
// update NUMBERS_WIDTH with the new width
NUMBERS_WIDTH = (short) Math.max(NUMBERS_WIDTH, width);

// line numbers rectangle (x, y, width, height)
g.drawRect(0, 0, NUMBERS_WIDTH, parent.getContainer().getHeight());