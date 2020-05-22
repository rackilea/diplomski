import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListViewController {

    private final ObservableList<String> myStrings = FXCollections.observableArrayList();

    public ListViewController() {
        myStrings.addAll("One", "Two", "Three");
    }

    public ObservableList<String> getMyStrings() {
        return myStrings ;
    }
}