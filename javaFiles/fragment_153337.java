public class ChildController {
    ...
    private ObservableList childList = FXCollections.observableArrayList();

    public ObservableList getChildList() {
        return childList;
    }
    // Some logic to load the list    
    ...
}