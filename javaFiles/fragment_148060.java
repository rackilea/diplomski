b_ingreso.addActionListener(new ActionListener() {
    public boolean b;

    public void actionPerformed(ActionEvent evento) {
        if(validar() == true){ // possible to use if here
           // show buttons if true    
        } else {
           // show something else if false    
        }
    }
}); // missing semicolon