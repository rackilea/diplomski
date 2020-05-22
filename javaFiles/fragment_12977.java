public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> createAndShowGui());
}

private static void createAndShowGui() {
    JFrame mainFrame = new JFrame("Java SWING Examples");
    ...
    mainFrame.setVisible(true);
}