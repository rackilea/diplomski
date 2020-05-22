@FXML
private void onPress(KeyEvent ev) throws IOException{
    kc = ev.getCode();
    if(kc == KeyCode.ESCAPE){
        strTRANSFER = txtEnterValue.getText();
        onBack();
    }   
}