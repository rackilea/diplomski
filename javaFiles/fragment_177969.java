Graphics2D G2D = this.getGraphics2D()
G2D.setColor(Color.white);
G2D.drawString("FPS: "+fps, 100, 100);
G2D.drawString("X: "+x_pos, 100, 80);
G2D.drawString("Y: "+y_pos, 100, 60);
G2D.drawString("Z: "+z_pos, 100, 40);
G2D.flush(false);