import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import javafx.stage.Stage;

public class Main extends Application {

    private Model m;
    private int num = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {

        TextField tf = new TextField();
        TextFormatter<String> textFormatter = new TextFormatter<>(
                TextFormatter.IDENTITY_STRING_CONVERTER, "", change -> 
            change.getControlNewText().length() > 10 ? null : change);

        tf.setTextFormatter(textFormatter);

        Button b = new Button("Click!");
        b.setOnAction(ev -> {
                    if (m != null) {
//                        tf.textProperty().unbindBidirectional(m.nameProperty());
                       textFormatter.valueProperty().unbindBidirectional(m.nameProperty());
                    }

                    m = new Model();
                    if (num % 2 == 0) {
                        System.out.println("Setting foo");
                        m.setName("foo");
                    } 
                    num++;

//                    tf.textProperty().bindBidirectional(m.nameProperty());
                    textFormatter.valueProperty().bindBidirectional(m.nameProperty());
                }
        );
        VBox vb = new VBox(tf, b);

        primaryStage.setScene(new Scene(vb));
        primaryStage.show();


    }

    public class Model {
        private SimpleStringProperty name = new SimpleStringProperty(this, "name", "");

        public StringProperty nameProperty() {
            return name;
        }

        public String getName() {
            return name.get();
        }

        public void setName(String name) {
            this.name.set(name);
        }

    }


    public static void main(String[] args) {
        launch(args);
    }

}