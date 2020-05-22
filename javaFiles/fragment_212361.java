//private JFrame mainFrame; you only have one instance, so no point in having a global field
private JLabel headerLabel;
private JLabel statusLabel;
private JPanel controlPanel;

private /*static Should that be there? answer is no. */ void prepareGUI() {
    JFrame mainFrame = new JFrame("Holy Bible");
    (...)
}