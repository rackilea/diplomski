BufferedImage image = ... //i'll leave this blank since there are several ways to get a bufferedimage. I'll leave an eg: ImageIO.read(new File("/path/to/image"));
        JPanel pane = new JPanel() {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, null);
        }};