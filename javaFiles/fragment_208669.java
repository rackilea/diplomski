// specify rows & columns
JTextArea jTextArea = new JTextArea(20, 20);

// specify preferred scrollable viewport size
JTextArea jTextArea = new JTextArea() {
    @Override
    public Dimension getPreferredScrollableViewportSize() {
        return new Dimension(470,500);
    }
};