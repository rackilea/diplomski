import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.RotateBuilder;
import javafx.stage.Stage;


public class JFXRotationXOrds  extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox();
        final Rotate rotate = RotateBuilder.create().angle(80).pivotX(100).pivotY(100).pivotZ(0).axis(new Point3D(1,0,0)).build();
        root.getTransforms().add(rotate);
        root.setStyle("-fx-border-color: black; -fx-border-width:5; ");

        root.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                if(arg0.getEventType() == MouseEvent.MOUSE_MOVED){
                    System.out.println(arg0.getSceneX() + "," + arg0.getSceneY());
                }
            }
        });

        Scene scene = new Scene(root, 200, 500);
        PerspectiveCamera camera = new PerspectiveCamera();
        scene.setCamera(camera);
        primaryStage.setTitle("BorderPane Example");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args){
        Application.launch(args);
    }
}