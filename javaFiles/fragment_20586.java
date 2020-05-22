public void CboSelect(){
 months = FXCollections.observableArrayList();
}

@FXML
public void getSP(){
    String selected = cboSP.getValue().toString();
    System.out.println("S S S selected "+selected); 
}