in = new JTextField(40);
f.addWindowListener( new WindowAdapter() {
    public void windowOpened( WindowEvent e ){
        in.requestFocus();
    }
});