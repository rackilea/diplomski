public class Main extends Application {

    @Override
    public void init() {
        // make sure we don't exit when file chooser is closed...
        Platform.setImplicitExit(false);
    }

    @Override
    public void start(Stage primaryStage) {
        File file = null ;
        FileChooser fc = new FileChooser();
        while(file == null){
            file = fc.showOpenDialog(primaryStage);
        }
        final File theFile = file ;
        new Thread(() -> runApplication(theFile)).start();
    }

    private void runApplication(File file) {
        // run your application here...
    }

}