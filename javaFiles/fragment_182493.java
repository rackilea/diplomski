for (int i = 0; i < 20; i++) {
    final JButton btnBookFlight = new JButton("Book" + i);
    btnBookFlight.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            btnBookFlight.setBackground(Color.RED);
            ...
        }
    });
}