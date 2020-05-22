import javafx.application.Application;
import javafx.stage.Stage;

public class FXApplication extends Application implements Runnable  {

    public void handleArgs(String[] args){
        // handle java args
        System.out.println(args);
    }        

    @Override
    public void start(Stage stage) throws Exception {
        // your javafx code
    }

    @Override
    public void run(){
        launch();
    }   
}