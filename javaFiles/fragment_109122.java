String command = event.getActionCommand();
if("upper".equals(command)){
  lowerCombo.removeActionListener(this);
  //Do your changes
  lowerCombo.addActionListener(this);
} else if("lower".equals(command)){
  //Do something
}