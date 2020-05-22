import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application { 

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane rootPane = new Pane();

        Label text = new Label();        
        text.setWrapText(true);
        text.setText("text text text text text text text text text text text");

        AnchorPane anchorPane = new AnchorPane();
        anchorPane.getChildren().add(text);
        anchorPane.setBackground(new Background(new BackgroundFill(Color.FORESTGREEN, CornerRadii.EMPTY, Insets.EMPTY)));

        rootPane.getChildren().add(anchorPane);
        rootPane.setBackground(new Background(new BackgroundFill(Color.FIREBRICK, CornerRadii.EMPTY, Insets.EMPTY)));

        primaryStage.setScene(new Scene(rootPane, 300, 275));
        primaryStage.show();

        rootPane.widthProperty().addListener(new ChangeListener<Number>() {

            private double textWidth;

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                if(text.getWidth() > 0 && textWidth == 0) {
                    textWidth = text.getWidth();
                }

                if(textWidth > 0 && textWidth > rootPane.getWidth())
                {
                    text.setPrefWidth(rootPane.getWidth());
                }else
                {
                    text.setPrefWidth(Label.USE_COMPUTED_SIZE);
                }
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}