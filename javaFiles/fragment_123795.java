package rn.IconTool.model;

 import java.io.IOException;
 import java.net.URL;
 import java.util.ResourceBundle;

 import javafx.fxml.FXML;
 import javafx.scene.control.ContextMenu;
 import javafx.scene.control.TreeView;
 import javafx.scene.input.MouseEvent;
 import javafx.scene.layout.AnchorPane;



 public class IconOverviewControllerClass implements javafx.fxml.Initializable{



 @FXML public TreeView<String> treeview;
 @FXML private AnchorPane splitPaneMenu;

 private static TreeView<String> statictreeView;

 public IconOverviewControllerClass(){

}



 @FXML
 public void initMyComponents(MouseEvent r) throws IOException{
     if(getTreeView() == null){
         System.out.println(treeview);
         statictreeView = treeview;
         System.out.println("static init: " + statictreeView);
     }


     ShowContextMenu(r);
 }


    public void ShowContextMenu(MouseEvent r){

        if(r.getButton() == r.getButton().SECONDARY){
            System.out.println("Rechtsklick");
            GetInTouchWithContextMenu git = new GetInTouchWithContextMenu();
            ContextMenu contextM = git.getTheContextMenu();
            System.out.println(contextM.toString());

            treeview.setContextMenu(contextM); 

            contextM.show(treeview, r.getX(), r.getY());
            System.out.println(contextM.isShowing());

            System.out.println("X: " + r.getX() + " Y: " + r.getY());   
        }

    }



    public TreeView<String> getTreeView() throws IOException{
        return statictreeView;
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //System.out.println(treeview);
        statictreeView = treeview;
    }
 }