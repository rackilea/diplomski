public static void main (String[] args) {
    JFrame f = new JFrame("Button UI Test");
    f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    JPanel p = new JPanel();
    p.setBackground(Color.white);
    f.setContentPane(p);
    p.setLayout(new FlowLayout(5, 5));
    p.setBorder(new EmptyBorder(10, 10, 10, 10));

    for (int i = 1; i <= 5; i++) {
        final JButton button = new JButton("Button #" + i);
        button.setFont(new Font("Calibri", Font.PLAIN, 14));
        button.setBackground(new Color(0x2dce98));
        button.setForeground(Color.white);
        // customize the button with your own look
        button.setUI(new StyledButtonUI());
        p.add(button);
    }

    f.pack();
    f.setLocation(500, 500);
    f.setVisible(true);
}