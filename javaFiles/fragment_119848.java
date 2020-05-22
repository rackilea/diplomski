AdvancedBevelBorder border = new AdvancedBevelBorder(new Color(120, 172, 220), new Color(55, 93, 128),
        new Color(73, 124, 169), new Color(150, 191, 229), new Color(36, 83, 126), 10);
JPanel panel = new JPanel() {
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 60);
    }
};
panel.setBackground(new Color(91, 154, 212));
panel.setBorder(border);