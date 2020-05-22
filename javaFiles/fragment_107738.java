for (int i = 1; i <= tablesNumber; i++) {
    final int t = i; // <-- NEW LINE HERE
    JButton button = new JButton(Integer.toString(i));
    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            new Orders(t).setVisible(true); // <-- USE t here however you need to
        }
    });
    jPanel1.add(button);
}