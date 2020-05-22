protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.scale(scale, 1);
            FontMetrics fm = g2d.getFontMetrics();
            msgWidth = fm.stringWidth(msg);
            g2d.drawString(msg, xPos, 40);
            g2d.dispose();
        }