Graphics2D surf = (Graphics2D) surface.create();
surf.translate(x,y);
image.draw(surf, width, height);
surface.setColor(Color.BLUE);
surface.fillRect(-5, -5, 10, 10);
surf.dispose();