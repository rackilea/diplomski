public void mouseDragged(MouseEvent e) {

            int dx = e.getX() - x;
            int dy = e.getY() - y;

            if (zrect.isHit(x, y)) {

                zrect.addX(dx);
                zrect.addY(dy);
                repaint();
            }

            if (zell.isHit(x, y)) {

                zell.addX(dx);
                zell.addY(dy);
                repaint();
            }

            x += dx;
            y += dy;
        }   
}