static class Frame extends JFrame {
        private static final String HTML_CONTENT = "<html><body><ol><li>one</li><li>Two</li></body></html>";

        JPanel panel = (JPanel)this.getContentPane();

        Frame () {
            this.pack();
            JLabel label = new JLabel (HTML_CONTENT);
            this.panel.add(label);
            this.setSize(new Dimension(200, 300));
            this.setVisible(true);
        }
    }