if(event.getSource instanceof JRadioButton){

  JRadioButton  btn=(JRadioButton)    event.getSource();
  if(btn.isSelected())
     btn.setSelected=false;
}
else if (event.getSource instanceof JCheckBox){   
  JCheckBox chb=  (JCheckBox)    event.getSource();
  if(chb.isSelected())
     chb.setSelected=false;
}