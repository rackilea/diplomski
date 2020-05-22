package two_windows;

import java.util.List;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class SelectedController {

    @FXML ListView<String> selected;

    void setModel(Model model) {

        //listen to changes in model, and respond
        model.getSelectedMessages().addListener(
                    (ListChangeListener<String>) c -> {
                        c.next();
                        removeElements(c.getRemoved());
                        addElements(c.getAddedSubList());
                    }
                );
    }

    private void removeElements(List<? extends String> msgList){

        for(String msg : msgList){
            selected.getItems().remove(msg);
        }
    }

    private void addElements(List<? extends String> msgList){

        for(String msg : msgList){
            selected.getItems().add(msg);
        }
    }
}