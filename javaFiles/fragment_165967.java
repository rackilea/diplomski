/* That is the class for storing information, which you need from your components*/
 public class DropedComponentsCoordinates implements Serializable{
private String componentID;
private String x_coord;
private String y_coord;
//and so on, whatever you need to get from yor serializable objects;
//getters and setters are assumed but not typed here.
 }

 /* I assume a variant with using FXML. If you don't - the main idea does not change*/
 public class YourController implements Initializable {

List<DropedComponentsCoordinates> dropedComponentsCoordinates;

@Override
public void initialize(URL url, ResourceBundle rb) {
    dropedComponentsCoordinates = new ArrayList();
}

//This function will be fired, every time 
//a user has dropped a component on the place he/she wants
public void OnDropFired(ActionEvent event) {
    try {
        //getting the info we need from components
        String componentID = getComponentID(event);
        String component_xCoord = getComponent_xCoord(event);
        String component_yCoord = getComponent_yCoord(event);

        //putting this info to the list
        DropedComponentsCoordinates dcc = new DropedComponentsCoordinates();
        dcc.setX_Coord(component_xCoord);
        dcc.setY_Coord(component_yCoord);
        dcc.setComponentID(componentID);

    } catch (Exception e) {
        e.printStackTrace();
    }
}

private String getComponentID(ActionEvent event){
    String componentID;
    /*getting cpmponentID*/
    return componentID;
}
private String getComponent_xCoord(ActionEvent event){
    String component_xCoord;
    /*getting component_xCoord*/
    return component_xCoord;
}
private String getComponent_yCoord(ActionEvent event){
    String component_yCoord;
    /*getting component_yCoord*/
    return component_yCoord;
}
}