private void goTo(int stX, int stY, int endX, int endY) {
        int dx = Math.abs(endX - stX);
        int dy = Math.abs(endY - stY);
        int sx = endX > stX ? 1 : -1;
        int sy = endY > stY ? 1 : -1;
        int err = dx - dy;
        while (stX != endX && stY != endY) {
            x = stX;
            y = stY;
            repaint();
            validate();
            if ((err*2) > -dy) {
                err -= dy;
                stX += sx;
            }
            if ((err*2) < dx) {
                err += dx;
                stY += sy;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {}
        }
    }