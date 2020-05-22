class MyCanvas extends Canvas {
            public void paint(Graphics g) {
                // create a 20x20 black square in the center

                // clear the screen first
                g.setColor(0xffffff);
                g.fillRect(0, 0, getWidth(), getHeight());

                g.setColor(0xffffff); // make sure it is white color

                // draw the square, <b>changed to rely on instance variables</b>
                <b>g.fillRect(x, y, getWidth(), getHeight());</b>
            }
        }