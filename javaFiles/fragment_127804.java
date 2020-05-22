public void setModel(Temp aTemp) {
    this.aTemp = aTemp;

    aTemp.tempProperty().addListener(this::updateLabelText) 

}}

private void updateLabelText() {
   Platform.runLater(() -> label.setText(aTemp.getTemp()));  
}