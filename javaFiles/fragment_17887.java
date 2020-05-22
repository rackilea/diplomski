public static class ButtonHandler implements ActionListener {

    private JButton b;

    public ButtonHandler(JButton b) {
        this.b = b;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        b.setBackground(Color.red);
    }

}