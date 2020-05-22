JTextField lastEdited;
private void init() {
    //other init stuff
    final JTextField hex = new JTextField("hex");
    final JTextField dec = new JTextField("dec");
    KeyListener keyListener = new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent e) {
            lastEdited = (JTextField) e.getSource();
        }
    };
    hex.addKeyListener(keyListener);
    dec.addKeyListener(keyListener);
    JButton convert = new JButton("Convert!");
    convert.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(lastEdited == hex) {
                dec.setText(Integer.toString(Integer.parseInt(hex.getText(), 16)));
            } else if(lastEdited == dec) {
                hex.setText(Integer.toHexString(Integer.parseInt(dec.getText())));
            }
        }
    });
    //other init stuff
}