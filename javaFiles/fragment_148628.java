private class DrawPane extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); 
            g.setColor(Color.YELLOW);
            g.fillRect(0, 0, 300, 400);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 400);
        }
    }