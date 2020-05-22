AbstractAction action = new AbstractAction(){

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }

};
//loop over the ascii char values
for ( char a = 'A'; a <= 'Z'; a++ ){
     panel.getInputMap().put(KeyStroke.getKeyStroke(Character.toString(a)), "recordTypedKey");
}
panel.getActionMap().put("recordTypedKey", action);