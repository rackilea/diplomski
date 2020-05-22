import javafx.application.Application;
import javafx.stage.Stage;

import java.util.logging.*;

public class Main extends Application {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    @Override
    public void start(Stage primaryStage) throws Exception {
        logger.log(Level.INFO, "App started. Message's visible");
        logger.log(Level.FINE, "Message's not visible");
    }

    public static void main(String[] args) {
        logger.setLevel(Level.FINE);

        Handler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.FINE);
        logger.addHandler(consoleHandler);

        launch(args);
    }
}