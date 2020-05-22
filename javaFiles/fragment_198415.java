public void stateChanged(ChangeEvent e){
  SpinnerNumberModel model = (SpinnerNumberModel)e.getSource();
  Integer value = (Integer)model.getValue();
  model2.setMinimum( value );
  model2.setMaximum( value + 9 );
  if( (Integer)model2.getValue() < value ){
    model2.setValue( value );
  } else if( (Integer)model2.getValue() > value + 9 ){
    model2.setValue( value + 9 );
  }
}