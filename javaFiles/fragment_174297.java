Try this as a your `paintComponent()` method.

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g.create();

        // And to smooth out the graphics, you can do the following
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(Color.RED);
        g2.fillRect(0, 0, 450, 450);
        g2.setColor(Color.BLACK);
        robot.drawRobot(g2);
        drawBoundedBeams(g2);
        obstacles.drawObstacles(g2);
        drawSun(g2);
        g2.dispose();
    }