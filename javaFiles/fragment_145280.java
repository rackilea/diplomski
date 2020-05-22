Graphics2D sg = (Graphics2D) g2d.create();
AffineTransform transform = new AffineTransform();
transform.translate((double) drawPosX, (double) drawPosY);
Shape outline = layout.getOutline(transform);

sg.setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
sg.setColor(Color.BLACK);
sg.draw(outline);
sg.dispose();