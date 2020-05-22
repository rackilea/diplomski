public class Main extends Application {

 @Override
 public void start(Stage primaryStage) throws Exception{

    FXMLLoader loader=new FXMLLoader(getClass().getResource("hive.fxml"));
    Parent root = loader.load();
    MyController cont=load.getController();
    /*
      This depends on your controller and you have to decide 
      How your controller need the arguments
    */
    cont.setParameter(getParameters()); 

    primaryStage.setTitle("Hive-viewer");
    primaryStage.setScene(new Scene(root, 1600, 900));
    primaryStage.show();
 }


 public static void main(String[] args) {
    launch(args);
 }
}