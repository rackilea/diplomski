public static void main(String[] args) {

    JFrame window = new JFrame();
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Hello Everyone!!");

    panel.add(label);
    window.add(panel);

    window.setVisible(true);
    window.pack();
    makeScreenshot(window);
}