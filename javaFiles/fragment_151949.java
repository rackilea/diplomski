JPanel panel1 = new JPanel();
JPanel panel2 = new JPanel();
JButton bt1 = new JButton();
JButton bt2 = new JButton();
panel1.add(bt1);
panel2.add(bt2);

bt1.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Bt1 on panel1 pressed");
    }
});

bt2.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Bt2 on panel2 pressed");
    }
});