private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JButton btnClose = new JButton("CLOSE");
    btnClose.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            frame.setVisible(false);
        }
    });
    frame.getContentPane().add(btnClose, BorderLayout.NORTH);
}