public void pressButton(ActionEvent event){               
    try {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sedondFXML.fxml"));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));  
            stage.show();
            main.stg.close();
    } catch(Exception e) {
       e.printStackTrace();
      }
 }