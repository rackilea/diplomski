public void paintComponent(Graphics g) {
        bullet = new Rectangle(bx, by, 10, 10);
        g.setColor(Color.RED);
        g.fillRect(x, y, 75, 25);
        g.fillRect(x + 32, y - 15, 10, 15);

        //you are messing with bx and by here.
        //probably because you wanted the bullet to be in the
        //same position as the ship.

        //this means they will be put back into the same position
        //for every time your game is painted to the screen.
        //my advice is, do *not* do this here.
        bx = x + 32;
        by = y - 15;

        if (shot == true) {
            g.setColor(Color.BLACK);
            g.fillRect(bx, by, bullet.width, bullet.height);
        }
        repaint();
    }