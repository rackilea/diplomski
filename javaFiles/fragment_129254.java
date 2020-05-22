// User ID acquired from a textbox called txt_user_id
int user_id = Integer.parseInt(this.txt_user_id.getText());

FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/Main.fxml"));     

Parent root = (Parent)fxmlLoader.load();          
MainController controller = fxmlLoader.<MainController>getController();
controller.setUser(user_id);
Scene scene = new Scene(root); 

stage.setScene(scene);    

stage.show();