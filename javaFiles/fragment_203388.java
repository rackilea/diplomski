import javafx.application.Application ;
import javafx.scene.stage.Stage ;
import javafx.scene.Scene ; 

public class DrawingLine extends Application{ 
   @Override 
   public void start(Stage stage) { 

      LineClass lc = new LineClass();

      //Creating a Scene 
      Scene scene = new Scene(lc.getView(), 600, 300); 

      //Setting title to the scene 
      stage.setTitle("Sample application"); 

      //Adding the scene to the stage 
      stage.setScene(scene); 

      //Displaying the contents of a scene 
      stage.show(); 
   }      
   public static void main(String args[]){ 
      launch(args); 
   } 
}