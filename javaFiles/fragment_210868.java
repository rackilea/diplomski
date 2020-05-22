import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author blj0011
 */
public class JavaFXApplication77 extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        Hyperlink link = new Hyperlink();
        link.setText("http://example.com");
        link.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("This link is clicked");
            }
        });

        Hyperlink link2 = new Hyperlink();
        link2.setText("http://example.com");
        link2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                System.out.println("This link is clicked");
            }
        });
        link.setOnMouseEntered((event) -> {
            link2.underlineProperty().setValue(Boolean.TRUE);
        });

        link.setOnMouseExited((event) -> {
            link2.underlineProperty().setValue(Boolean.FALSE);
        });


        VBox vbox = new VBox();
        vbox.getChildren().addAll(link, link2);
        StackPane root = new StackPane();
        root.getChildren().add(vbox);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

}