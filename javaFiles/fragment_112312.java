package two_windows;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Model {

    private final ObservableList<String> list;
    private ObservableList<String> selected;

    Model(){
        list = FXCollections.observableArrayList();
    }

    void addMessage(String msg){
        list.add(msg);
    }

    ObservableList<String> getMessages(){
        return list;
    }

    ObservableList<String> getSelectedMessages(){
        return selected;
    }

    void setSelected(ObservableList<String> selected) {
        this.selected = selected;
    }
}