public class BookViewController implements Initializable {

    // @FXML-annotated fields omitted...

    private final Trip rowData;

    public BookViewController(Trip rowData) {
        this.rowData = rowData ;
    }

    // remove this, it is now initialized in the constructor
    // public void setRowData(Trip rowData) {
    //     this.rowData = rowData;
    //     // The below println is never printed to the console..
    //     System.out.println("Test");
    // }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        addTraveler.setDisable(true);
        removeTraveler.setDisable(true);
        populateTravelPlan();
    }

    // etc...
}