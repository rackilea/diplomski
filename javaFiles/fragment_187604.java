public FlippingCoins2() {
    final JPanel p = new JPanel();

    p.setLayout(new GridLayout(3, 3, 1, 1));

    for (int i = 0; i < 9; i++) {
        final JLabel jlb = new JLabel("H", SwingConstants.CENTER);
        jlb.setBorder(BorderFactory.createLineBorder(Color.blue));
        jlb.setName("" + i);
        jlb.addMouseListener(new MouseAdapter() {

            public void mouseClicked(final MouseEvent e) {
                jlb.setText("T");
                System.out.println(jlb.getName());
            }
        });
        p.add(jlb);
    }
    setContentPane(p);
}