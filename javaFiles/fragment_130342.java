import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DragApplication extends Application{

    private double startX = 0, startY = 0;

    @Override
    public void start( Stage primaryStage) throws Exception{
        EventHandler< MouseEvent> clicked = e -> System.out.printf( "%s clicked%n", e.getTarget());

        EventHandler< MouseEvent> pressed = e -> {
            startX = e.getX();
            startY = e.getY();
        };

        EventHandler< MouseEvent> dragged = e -> {
            Node n = (Node) e.getTarget();
            //in case of button it returns the Text node not the button
            if(n instanceof Text)
                n = n.getParent();
            n.layoutXProperty().set( n.getLayoutX() + e.getX() - startX);
            n.layoutYProperty().set( n.getLayoutY() + e.getY() - startY);
        };

        Button paneButton = new Button( "Pane Button");
        paneButton.setOnAction( a -> System.out.println( "Pane Button Action"));
        paneButton.setOnMouseClicked( clicked);
        paneButton.setOnMousePressed( pressed);
        paneButton.setOnMouseDragged( dragged);

        Pane pane = new Pane( paneButton);
        pane.setLayoutX( 200);
        pane.setOnMouseClicked( clicked);
        pane.setOnMousePressed( pressed);
        pane.setOnMouseDragged( dragged);
        pane.setStyle( "-fx-background-color: GREEN; -fx-min-width:200; -fx-min-height:200;");

        Button achoreButton = new Button( "Anchor Button");
        achoreButton.setOnAction( a -> System.out.println( "Anchor Button Action"));
        achoreButton.setOnMouseClicked( clicked);
        achoreButton.setOnMousePressed( pressed);
        achoreButton.setOnMouseDragged( dragged);

        Button transparentAchoreButton = new Button( "Transparent Anchor Button");
        transparentAchoreButton.setMouseTransparent( true);
        transparentAchoreButton.setOnAction( a -> System.out.println( "Anchor Button Action"));
        transparentAchoreButton.setOnMouseClicked( clicked);
        transparentAchoreButton.setOnMousePressed( pressed);
        transparentAchoreButton.setOnMouseDragged( dragged);

        AnchorPane anchor = new AnchorPane(achoreButton, transparentAchoreButton);
        AnchorPane.setTopAnchor( achoreButton, 10.0);
        AnchorPane.setLeftAnchor( achoreButton, 10.0);
        AnchorPane.setBottomAnchor( transparentAchoreButton, 10.0);
        AnchorPane.setRightAnchor( transparentAchoreButton, 10.0);
        anchor.setOnMouseClicked( clicked);
        anchor.setOnMousePressed( pressed);
        anchor.setOnMouseDragged( dragged);
        anchor.setStyle( "-fx-background-color: RED; -fx-min-width:200; -fx-min-height:200;");

        Pane root = new Pane(  anchor,pane);

        primaryStage.setScene( new Scene( root, 600, 400));
        primaryStage.setTitle( "Text scaling problem");
        primaryStage.show();
    }

    public static void main( String[] args){
        launch( args);
    }
}