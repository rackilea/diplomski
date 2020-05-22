public class DragNode extends BorderPane implements Initializable{

    public DragNode () {


        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/main/resources/fxml/DragNode.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

      //call it here so you are sure fxml layout has been initialized
      setNodes();

    }

    private void setNodes() {

        Circle inpNode = new Circle();
        this.getChildren().add(inpNode);

        inpNode.setRadius(10.0);
        inpNode.setCenterX(this.getBoundsInParent().getMaxX());
        inpNode.setCenterY(this.getBoundsInParent().getMaxY() / 2.0);

        System.out.println(this.getBoundsInParent());   // Prints 'BoundingBox [minX:0.0, minY:-5.0, ... ]'
        System.out.println(this.getParent());           // Prints null
        System.out.println(this.getChildren());         // Prints 1
    }
}