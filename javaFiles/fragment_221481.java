import java.util.List;
import javax.xml.bind.annotation.XmlAnyElement;
import javafx.collections.*;

public class MyWrapperForList<T> {

    private List<T> list = FXCollections.<T>observableArrayList();

    public MyWrapperForList() {
        list = FXCollections.<T>observableArrayList();
    }

    public MyWrapperForList(List<T> list) {
        this.list = list;
    }

    @XmlAnyElement(lax = true)
    public List<T> getItems() {
        return list;
    }

}