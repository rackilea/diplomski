import javax.xml.bind.annotation.XmlAnyElement;
import javafx.collections.*;

public class MyWrapperForList<T> {

    private ObservableList<T> list;

    public MyWrapperForList() {
        list = FXCollections.<T>observableArrayList();
    }

    public MyWrapperForList(ObservableList<T> list) {
        this.list = list;
    }

    @XmlAnyElement(lax = true)
    public ObservableList<T> getItems() {
        return list;
    }

}