public static void main(String[] args) {
    JFrame frame = new JFrame("test");
    frame.setSize(900, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new CardLayout());
    frame.setVisible(true);
    LateralSupportPane p = new LateralSupportPane();
    frame.add(p);
    frame.validate();
    p.addLabel("test 2");
    p.validate();
}