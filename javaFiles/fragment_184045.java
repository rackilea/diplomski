import javax.swing.ListSelectionModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JList;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionListener;

/**
*
* @author MaskedCoder
*/
public class ActionListSelectionModel extends DefaultListSelectionModel implements ListSelectionModel {
    ListModel thisModel;

    public ActionListSelectionModel(JList iniList) {
        super();
        thisModel = iniList.getModel();
        super.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        super.setAnchorSelectionIndex(thisModel.getSize() - 1);
        // maybe add datalistener to update AnchorSelection when items added/removed
    }

    private int betterOf(int index0, int index1) {
        if(index0 < 0) return index1;
        else if (index1 < 0) return index0;
        else return ((index0 < index1) ? index1 : index0);
    }

    /*
    * ListSelectionModel implementation
    */
    @Override
    public void setSelectionInterval(int index0, int index1) {
        super.setSelectionInterval(thisModel.getSize() - 1, betterOf(index0, index1));
    }

    @Override
    public void addSelectionInterval(int index0, int index1) {
        // don't want to add, so just do same as above
        super.setSelectionInterval(thisModel.getSize() - 1, betterOf(index0, index1));
    }

    @Override
    public void setAnchorSelectionIndex(int anchorIndex) {
        super.setAnchorSelectionIndex(thisModel.getSize() - 1);
    }

    @Override
    public void insertIndexInterval(int index, int length, boolean before) {
        super.setSelectionInterval(thisModel.getSize() - 1, index);
    }

    @Override
    public void removeIndexInterval(int index0, int index1) {
        // do nothing.  Only (1) interval and it will never be removed.
    }

    @Override
    public void setSelectionMode(int selectionMode) {
        super.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    }

}