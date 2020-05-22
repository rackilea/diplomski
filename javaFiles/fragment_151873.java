import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ToggleButtonDemo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Toggle Button");
        stage.setWidth(150);
        stage.setHeight(150);

        final ToggleGroup group = new ToggleGroup();

        group.selectedToggleProperty().addListener(
                new ChangeListener<Toggle>() {
                    public void changed(ObservableValue<? extends Toggle> ov,
                            Toggle oldToggle, Toggle newToggle) {
                        if (null != newToggle)
                            System.out.println(group.getSelectedToggle()
                                    .getUserData());
                    }
                });

        ToggleButton toggleButton1 = new ToggleButton("A");
        toggleButton1.setToggleGroup(group);
        toggleButton1.setUserData("You Clicked on A");

        ToggleButton toggleButton2 = new ToggleButton("B");
        toggleButton2.setToggleGroup(group);
        toggleButton2.setUserData("You Clicked on B");

        ToggleButton toggleButton3 = new ToggleButton("C");
        toggleButton3.setToggleGroup(group);
        toggleButton3.setUserData("You Clicked on C");

        HBox hbox = new HBox();

        hbox.getChildren().add(toggleButton1);
        hbox.getChildren().add(toggleButton2);
        hbox.getChildren().add(toggleButton3);

        ((Group) scene.getRoot()).getChildren().add(hbox);
        stage.setScene(scene);
        stage.show();
    }
}