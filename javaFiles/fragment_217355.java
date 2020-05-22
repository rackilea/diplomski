public class AddRowAction extends AbstractTableAction<DefaultTableModel> {

    public AddRowAction(JTable table, DefaultTableModel model) {
        super(table, model);
        putValue(NAME, "Add");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Add @ " + getSelectedRow() + "x" + getSelectedColumn());
    }

}

public class DeleteRowAction extends AbstractTableAction<DefaultTableModel> {

    public DeleteRowAction(JTable table, DefaultTableModel model) {
        super(table, model);
        putValue(NAME, "Delete");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Delete @ " + getSelectedRow() + "x" + getSelectedColumn());
    }

}

public class EditRowAction extends AbstractTableAction<DefaultTableModel> {

    public EditRowAction(JTable table, DefaultTableModel model) {
        super(table, model);
        putValue(NAME, "Edit");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Edit @ " + getSelectedRow() + "x" + getSelectedColumn());
    }

}