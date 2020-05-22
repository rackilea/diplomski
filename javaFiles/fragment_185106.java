import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class MyTestPane extends BorderPane {

    private MyTestPaneView controller ;

    public MyTestPane() {
        try {
            FXMLLoader loader = new FXMLLoader();
//            loader.setLocation(Thread.currentThread().getContextClassLoader().getResource("MyTestPaneView.fxml"));
            loader.setLocation(getClass().getResource("MyTestPaneView.fxml"));
            loader.setControllerFactory(cl -> new MyTestPaneView());
            final Pane pane = loader.load();

            controller = loader.getController();

            setCenter(pane);

            Button gc = new Button("GC");
            gc.setOnAction(e -> System.gc());
            setBottom(gc);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}