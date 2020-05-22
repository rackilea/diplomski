final JTextField hex = new JTextField("hex");
final JTextField dec = new JTextField("dec");
ActionListener act = new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == hex) {
            dec.setText(Integer.toString(Integer.parseInt(hex.getText(), 16)));
        } else if(e.getSource() == dec) {
            hex.setText(Integer.toHexString(Integer.parseInt(dec.getText())));
        }
    }
};
hex.addActionListener(act);
dec.addActionListener(act);