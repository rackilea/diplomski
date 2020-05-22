private JLabel label;
private JButton button;

MyPanel() {
    ...
    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText("button clicked");
        }
    }
}