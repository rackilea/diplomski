import java.io.IOException;                                                                                         
import javafx.application.Application;                                                                              
import javafx.fxml.FXMLLoader;                                                                                      
import javafx.scene.Scene;                                                                                          
import javafx.scene.control.Button;                                                                                 
import javafx.scene.layout.BorderPane;                                                                              
import javafx.scene.layout.Pane;                                                                                    
import javafx.scene.layout.StackPane;                                                                               
import javafx.stage.Stage;                                                                                          

public class SwitchPanesDemo extends Application                                                                    
{                                                                                                                   

    private Pane page0, page1;                                                                                      
    private Button toggle;                                                                                          
    String[] buttonText = {"Show Page 1", "Show Page 2"};                                                           

    @Override                                                                                                       
    public void start(Stage primaryStage) {                                                                         
        try {                                                                                                       

            page0 = (Pane) FXMLLoader.load(getClass().getResource("redPane.fxml"));                                 
            page1 = (Pane) FXMLLoader.load(getClass().getResource("yellowPane.fxml"));                              
            page0.visibleProperty().bind(page1.visibleProperty().not());//make sure only one pane is visible        
            page1.setVisible(false);                                                                                
            StackPane stackPane = new StackPane(page0, page1);//add both panes to a stack pane                      
            BorderPane root = new BorderPane(stackPane);                                                            
            toggle = new Button(buttonText[0]);                                                                     
            toggle.setOnAction(e->togglePages(toggle.getText()));                                                   
            root.setBottom(toggle);                                                                                 
            Scene scene = new Scene(root);                                                                          
            primaryStage.setScene(scene);                                                                           
            primaryStage.show();                                                                                    
        }                                                                                                           
        catch (IOException e) {                                                                                     
            e.printStackTrace();                                                                                    
        }                                                                                                           
    }                                                                                                               

    private void togglePages(String text) {                                                                         

        if(buttonText[0].equals(text)){                                                                             
            page1.setVisible(true);                                                                                 
            toggle.setText(buttonText[1]);                                                                          
        }else{                                                                                                      
            page1.setVisible(false);                                                                                
            toggle.setText(buttonText[0]);                                                                          
        }                                                                                                           
    }                                                                                                               

    public static void main(String[] args) {                                                                        
        launch(args);                                                                                               
    }                                                                                                               
}