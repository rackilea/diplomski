import com.vaadin.ui.Grid.SelectionModel;
import com.vaadin.ui.Grid.SingleSelectionModel;

public class SingleSelectionModelNotChecked extends SingleSelectionModel implements SelectionModel {

    @Override
    protected void checkItemIdExists(Object itemId) throws IllegalArgumentException {
    // Nothing to do. No check is done, no exception is launched when the filter is applying. 
    }
}