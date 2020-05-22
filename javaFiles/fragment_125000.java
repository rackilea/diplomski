if(ae.getSource() == this.buttonOK){

    label.setText(" ");
    buttonOK.setEnabled(false);
    tfName.setEnabled(false);

    if(x!=null){
        abspeichern(name[x]);
    }
 }