public class Main extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        stage.initStyle(StageStyle.UTILITY);
        stage.setResizable(false);
        Login loginview = new Login();
        Scene scene = new Scene(loginview, 400, 200);
        stage.setScene(scene);
        stage.show();       
    }

    public static void main(String[] args){
        launch(args);
    }
}