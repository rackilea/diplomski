public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Panel Size = 400 X 400
        g.drawLine(200, 0, 200, 400); // Draw Y Axis
        g.drawLine(0, 200, 400, 200); // Draw X Axis

        // Create Transform
        AffineTransform at = new AffineTransform();
        at.translate(200, 200); // Move Center Form (0, 0) To JPanel Center (200, 200)

        // Change Transform - Test One Line At Once For Study :) 
        //at.translate(-200, 0); // Move Center
        //at.rotate(Math.toRadians(90)); // Rotate
        //at.scale(1, -1); // Scale, But Use For Flip

        // Set Transform To Graphics2D
        Graphics2D g2d = (Graphics2D) g;
        g2d.setTransform(at);

        // Draw Rectangle By Graphics2D
        g2d.fillRect(100, 100, 100, 100);
    }