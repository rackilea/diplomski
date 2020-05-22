private JLabel label;

public JLabelContainer() {
   label = new JLabel();
}

public void updateLabel(String text){
  label.setText(text);
}