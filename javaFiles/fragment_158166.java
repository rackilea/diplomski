import java.util.Arrays;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.jface.viewers.ViewerColumn;

public class RowNumberLabelProvider extends CellLabelProvider {

    private TableViewer viewer;

    protected void initialize(ColumnViewer viewer, ViewerColumn column) {
        super.initialize(viewer, column);
        this.viewer = null;
        if (viewer instanceof TableViewer) {
            this.viewer = (TableViewer) viewer;
        }
    }

    public void update(ViewerCell cell) {
        super.update(cell);
        if (viewer != null) {
            int index = Arrays.asList(viewer.getTable().getItems()).indexOf(cell.getItem());
            cell.setText("" + (index + 1));
        }
    }
}