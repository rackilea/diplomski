public class DesktopApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        BuildGraphicalUserInterface ui = new BuildGraphicalUserInterface();
        ui.initStage(primaryStage);
    }

   public static void main(String[] args) {
       launch(args);
   }
}