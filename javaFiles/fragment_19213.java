import javafx.application.Platform;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class GamePane extends Pane
{

    private VBox content;
    private HBox textBox;

    private VisualPane visualPane;
    private TextPane textPane;

    public GamePane()
    {
        initialize();
    }

    private void initialize()
    {
        this.content = new VBox();
        getChildren().add(content);
        this.textBox = new HBox();

        this.visualPane = new VisualPane();
        this.textPane = new TextPane();

        content.getChildren().add(visualPane);
        content.getChildren().add(textBox);
        textBox.getChildren().add(textPane);

        this.setOnKeyReleased(e -> {//Change here!
            switch (e.getCode()) {

                case ENTER:
                    this.textPane.push("Enter pressed.");
                    break;

                case SPACE:
                    this.textPane.push("Space pressed.");
                    break;

                case ESCAPE:
                    System.out.println("escaped pressed");
                    Platform.exit();
                    break;
            }
        });

        this.requestFocus();//Change here!
    }
}