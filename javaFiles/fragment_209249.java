public static void main(String[] args) {
    inAttic = true;
    px = 600;
    py = 400;
    //frame.setSize(1200, 800);
    ForgottenMain fm = new ForgottenMain();
    frame.add(fm);
    frame.pack();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);

    frame.setVisible(true);
    fm.repaint();
}