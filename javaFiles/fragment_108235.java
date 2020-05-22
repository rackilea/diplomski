public static void main(String[] args) {
    JFrame frame = new JFrame();
    DynamicJPanel dynamic = new DynamicJPanel();
    frame.add(dynamic.createTipTailoringPanel(3));
    frame.pack();
    frame.setVisible(true);
}

JPanel createTipTailoringPanel(int size) {
    JPanel content = new JPanel();
    content.setLayout(new GridLayout(0, 4));

    for (int i = 0; i < size; i++) {
        content.add(new JTextField());
        content.add(new JSlider());
        content.add(new JLabel("$"));
        content.add(new JLabel());
    }

    return content;
}