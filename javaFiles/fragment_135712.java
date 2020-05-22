public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader();

        Parent root = fxmlLoader.load(getClass().getResource("sample.fxml"));
        Controller controller = fxmlLoader.getController();

        primaryStage.setTitle("uPick Smart Service");
        primaryStage.setScene(new Scene(root, 1600, 600));

        primaryStage.show();

        ConnectionHandling connectionHandling = new ConnectionHandling(controller);
        Thread X = new Thread (connectionHandling);
        X.start();

    }

    public static void main(String args[]){
        launch(args);

    }

    public Controller getController(){
        return controller;
    }


}