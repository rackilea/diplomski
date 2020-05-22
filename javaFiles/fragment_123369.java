package sample;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        AnchorPane rootPane = new AnchorPane();
        Scene scene = new Scene(rootPane, 400, 300);

        GridPane grid = new GridPane();
        MaximizeInAnchorPane(grid);

        // make column and rows resize
        for (int i=0;i <5;i++)
        {
            ColumnConstraints cConstrain = new ColumnConstraints();
            cConstrain.setHgrow(Priority.SOMETIMES);
            grid.getColumnConstraints().add(cConstrain);

            RowConstraints rConstrain = new RowConstraints();
            rConstrain.setVgrow(Priority.SOMETIMES);
            grid.getRowConstraints().add(rConstrain);
        }

        for (int i=0;i <5;i++)
        {
            for (int j=0;j <5;j++)
            {
                // create button and put it in an AnchorPane, that will resize it
                AnchorPane buttonPane = new AnchorPane();
                Button button = new Button("Button");
                MaximizeInAnchorPane(button);
                buttonPane.getChildren().add(button);

                grid.add(buttonPane,i,j);
            }
        }

        rootPane.getChildren().add(grid);
        primaryStage.setTitle("test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private static void MaximizeInAnchorPane(Node toMaximize)
    {
        AnchorPane.setTopAnchor(toMaximize, 0.0);
        AnchorPane.setRightAnchor(toMaximize, 0.0);
        AnchorPane.setLeftAnchor(toMaximize, 0.0);
        AnchorPane.setBottomAnchor(toMaximize, 0.0);
    }

    public static void main(String[] args) {
        launch(args);
    }
}