public FlippingCoins() {
    final JPanel p = new JPanel();

    p.setLayout(new GridLayout(3, 3, 1, 1));

    for (int i = 0; i < 9; i++) {
        final JButton jbt = new JButton("H");
        jbt.setName("" + i);
        jbt.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                jbt.setText("T");
                System.out.println(jbt.getName());
            }
        });
        p.add(jbt);
    }
    setContentPane(p);
}