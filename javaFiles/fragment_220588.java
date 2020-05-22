public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setBounds(0, 0, 300, 400);
    frame.setLayout(null);
    final JTabbedPane tabbedPane = new JTabbedPane();
    tabbedPane.addTab("One", new JPanel());
    tabbedPane.addTab("Two", new JPanel());
    tabbedPane.addTab("Three", new JPanel());
    tabbedPane.addChangeListener(new ChangeListener() {
        public void stateChanged(ChangeEvent e) {
            System.out.println("Tab: " + tabbedPane.getSelectedIndex());
        }
    });
    tabbedPane.setBounds(0, 0, 300, 400);
    frame.add(tabbedPane);
    frame.setVisible(true);
}