JButton component = new JButton(text);
FontMetrics fontMetrics = component.getFontMetrics(component.getFont());
LineMetrics metrics = fontMetrics.getLineMetrics(text, component.getGraphics());

float ascent = metrics.getAscent(), descent = metrics.getDescent();
component.setAlignmentY(ascent / (ascent + descent));