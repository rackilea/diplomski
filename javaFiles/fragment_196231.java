public void draw(Graphics2D g) 
    {
        g.setColor(Color.WHITE);
        g.fillOval ((int) (x - r), (int) (y - r), (int)
                (2 * r),
                (int) (2 * r));

        x++; // Left to right movement
        // Example, modify the multipliers as necessary
        y = 100 * Math.sin(Math.toDegrees(x/4))
    }