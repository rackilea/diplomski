import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.converter.DefaultStringConverter;

public class EditableListViewTest extends Application {

    @Override
    public void start(Stage primaryStage) {
        ListView<String> list = new ListView<>();
        Image testImg = new Rectangle(12, 12, Color.CORNFLOWERBLUE).snapshot(null, null);
        for (int i = 0; i < 6; i++) {
            list.getItems().add("label "+i);
        }

        StringConverter<String> identityStringConverter = new DefaultStringConverter();

        list.setCellFactory(lv -> new TextFieldListCell<String>(identityStringConverter) {

            private ImageView imageView = new ImageView(testImg);


            @Override
            public void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (! empty && ! isEditing()) {
                    setStaticGraphic();
                }
            }

            @Override
            public void cancelEdit() {
                super.cancelEdit();
                setStaticGraphic();
            }

            @Override
            public void commitEdit(String newValue) {
                super.commitEdit(newValue);
                setStaticGraphic();
            }

            private void setStaticGraphic() {
                setGraphic(imageView);
                setContentDisplay(ContentDisplay.LEFT);
                setGraphicTextGap(10.2);                
            }
        });

        list.setEditable(true);

        primaryStage.setScene(new Scene(new BorderPane(list), 250, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}