public HandlerRegistration addClickHandlerForCheckBox(CheckBox myCheckBox) {
 return myCheckBox.addClickHandler(new MyClickHandler(myCheckBox));
}
public void showData() {
  resetVariables();
  postCodeHandlerReg = addClickHandlerForCheckBox(postCode);
 countryHandlerReg = addClickHandlerForCheckBox(country);
}