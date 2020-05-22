ActionListener actionListener = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
        case "PLUS":
            // DO SOMTHING:
            break;
        case "MULT":
            // DO SOMTHING:
            break;
        default:
            break;
        } 
    }
};

JButton b = new JButton("+");
b.setActionCommand("PLUS");
b.addActionListener(actionListener);

JButton b1 = new JButton("*");
b1.setActionCommand("MULT");
b1.addActionListener(actionListener);