boolean _internalChange = false;

void init(){
  ComboBox myCombo = new ComboBox();
  myCombo.addValueChangeListener(event -> {
    if(_internalChange) {
      // do something
    } else {
      // do something else
    }
  });
}

void selectMyCombo(Object value){
  _internalChange = true;
  myCombo.select(stuff)
  _internalChange = false;
}