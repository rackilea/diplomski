GC gc = new GC(control);
gc.setFont(control.getFont());
FontMetrics fontMetrics = gc.getFontMetrics();
gc.dispose();

data.widthHint = Dialog.convertWidthInCharsToPixels(fontMetrics, charCount);