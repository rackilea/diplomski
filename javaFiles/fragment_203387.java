import javafx.scene.Group ;
import javafx.scene.Parent ;
import javafx.scene.shape.Line ;

public class LineClass {

    private final Group root ;

    public LineClass() {

        //Creating a line object 
        Line line = new Line(); 

        //Setting the properties to a line 
        line.setStartX(100.0); 
        line.setStartY(150.0); 
        line.setEndX(500.0); 
        line.setEndY(150.0); 

        root = new Group(line); 
    }

    public Parent getView() {
        return root ;
    }
}