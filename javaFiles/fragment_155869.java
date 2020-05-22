import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;


public class ColorFactory extends Application {
    Button red;
    Button yellow;
    Button orange;

    RadioButton green;
    RadioButton  blue;
    RadioButton cyan; 

    Label label;

    @Override
    public void start(Stage stage)
    {
        BorderPane pane = new BorderPane();
        // sets the width and height
        stage.setHeight(300);
        stage.setWidth(500);

        //calls the mainpanel constructor
        pane.setCenter(new MainPanel());

        //make the mainpanel visible using the setVisible(true)

        //call the stage.setScene
        stage.setScene(new Scene(pane));
        // set title to Color Factory
        stage.setTitle("Color Factory");
        //call stage.show
        stage.show();
    }
    private class MainPanel extends BorderPane
    {


        public MainPanel()
        {
            HBox Tpanel = new HBox(25);
            Tpanel = new HBox(25);
            Tpanel.setPrefWidth(500);
            Tpanel.setPrefHeight(50);
            Tpanel.setAlignment(Pos.TOP_CENTER);
            red = new Button("Red");
            yellow = new Button("Yellow");
            orange = new Button("Orange");
            red.setStyle("-fx-background-color: red");
            orange.setStyle("-fx-background-color: orange;");
            yellow.setStyle("-fx-background-color: yellow;");
            orange.setOnAction(new ButtonListener());
            red.setOnAction(new ButtonListener());
            yellow.setOnAction(new ButtonListener());
            Tpanel.setStyle("-fx-background-color: white;");
            Tpanel.getChildren().addAll(red,yellow,orange);


            HBox Bpanel = new HBox(15);
            Bpanel.setPrefWidth(500);
            Bpanel.setPrefHeight(75);
            green = new RadioButton("Green");
            blue = new RadioButton("Blue");
            cyan = new RadioButton("Cyan"); 
            blue.setOnAction(new RadioButtonListener());
            green.setOnAction(new RadioButtonListener());
            cyan.setOnAction(new RadioButtonListener());
            green.setStyle("-fx-background-color: green;");
            blue.setStyle("-fx-background-color: blue;");
            cyan.setStyle("-fx-background-color: cyan;");
            Bpanel.setAlignment(Pos.BOTTOM_CENTER);
            Bpanel.getChildren().addAll(green,blue,cyan);

            label = new Label("Top buttons change the panel color and bottom radio buttons change the text color");
            label.setAlignment(Pos.CENTER_LEFT);
            label.setTextFill(Color.BLUE);

            setTop(Tpanel);
            setBottom(Bpanel);
            setCenter(label);

            HBox.setMargin(Tpanel, new Insets(5,10,5,10));
            HBox.setMargin(Bpanel, new Insets(5,10,5,10));
            HBox.setMargin(label, new Insets(150,10,5,10));




        }

    }
    private class ButtonListener implements EventHandler<ActionEvent>
    {

        public void handle(ActionEvent event) 
        {

            if(event.getSource() == red)
            {
                red.setStyle("-fx-background-color: red;");
            }
            else if(event.getSource() == yellow)
            {
                yellow.setStyle("-fx-background-color: yellow;");
            }
            else 
            {
                orange.setStyle("-fx-background-color: orange;");
            }
        }
    }
    private class RadioButtonListener implements EventHandler<ActionEvent>
    {
        public void handle(ActionEvent radio)
        {
            if(radio.getSource() == green)
            {
                label.setTextFill(Color.GREEN);
            }
            if(radio.getSource() == blue)
            {
                label.setTextFill(Color.BLUE);
            }
            if(radio.getSource() == cyan)
            {
                label.setTextFill(Color.BLUE);
            }
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}