package two_windows;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TwoWindows extends Application {

    private Model model;

    @Override
    public void start(Stage primaryStage) throws Exception{

        model = new Model();

        FXMLLoader listLoader = new FXMLLoader(getClass().getResource("List.fxml"));
        Parent list = listLoader.load();
        ListController listController = listLoader.getController();
        listController.setModel(model);

        FXMLLoader selectedLoader = new FXMLLoader(getClass().getResource("Selected.fxml"));
        Parent selected = selectedLoader.load();
        SelectedController selectedController = selectedLoader.getController();
        selectedController.setModel(model);

        primaryStage.setScene(new Scene(list));
        primaryStage.setX(350); primaryStage.setY(300);

        Stage secondaryStage = new Stage();
        secondaryStage.setScene(new Scene(selected));
        secondaryStage.setX(550); secondaryStage.setY(300);

        addMessages();
        primaryStage.show();
        secondaryStage.show();
    }

    private void addMessages() {

        int counter = 0;
        while(counter < 15) {
            model.addMessage("message number "+ counter++);
        }
    }

    public static void main(final String[] args) {
        launch(args);
    }
}