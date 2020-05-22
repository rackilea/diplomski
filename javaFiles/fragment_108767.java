public void createWindow(int height, int width, String title) {
    JFrame window = new JFrame();
    window.setSize(width, height);
    window.setTitle(title);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel jp = new JPanel();
    JTextField jt = new JTextField(30);
    jp.add(jt);
    window.add(jp);
    window.setVisible(true);
}