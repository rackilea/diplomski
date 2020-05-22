import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class SecondaryController {
    @FXML ListView<String> lvMain;
    @FXML ComboBox<String> cbMain;
    @FXML TextArea taMain;

    private DataModel model ;

    public void initModel(DataModel model) {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model ;

        lvMain.setItems(this.model.getListViewData());
        cbMain.setItems(this.model.getComboBoxData());
        taMain.setText(this.model.getTextAreaData());
    }
}