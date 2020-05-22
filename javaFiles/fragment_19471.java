if(event.getSource instanceof JRadioButton){

 JRadioButton  btn=(JRadioButton)    event.getSource();
    btn.setSelected=false;
}
else if (event.getSource instanceof JCheckBox){

  JCheckBox chb=  (JCheckBox)    event.getSource();
    chb.setSelected=false;
}