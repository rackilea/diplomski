Graphics2D sg = (Graphics2D) g2d.create();
AffineTransform transform = new AffineTransform();
transform.translate((double) drawPosX, (double) drawPosY);
Shape outline = layout.getOutline(transform);

sg.setColor(Color.WHITE);
sg.fill(outline);
sg.setColor(Color.BLACK);
sg.draw(outline);
sg.dispose();