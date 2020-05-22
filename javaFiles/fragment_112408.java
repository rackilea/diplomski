public class MyRenderer extends DefaultTableCellRenderer {
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int rowViewId, int columnViewId) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, rowViewId, columnViewId);
        Etudiant E = new Etudiant();

        int rowModelId = table.convertRowIndexToModel(rowViewId); // << for lookup of values in the model
        int colModelId = table.convertColumnIndexToModel(columnViewId); // << for lookup of values in the model

        if (colModelId == 0) { // << you mean to check if the model index is 0 here
            int id = E.getAIdEtud(table.getModel().getValueAt(rowModelId, 1).toString(), table.getModel().getValueAt(rowModelId, 2).toString()); // << when indexing the model, use model indexes
            if (E.IsRoudoublan(id) && E.IsExcclu(id)) {
                c.setBackground(new java.awt.Color(0, 0, 255));
            } else if (E.IsExcclu(id)) {
                c.setBackground(new java.awt.Color(255, 0, 0));
            } else if (E.IsRoudoublan(id)) {
                c.setBackground(new java.awt.Color(20, 200, 0));
            }
            // << provide ELSE part here, eg:
            else {
                c.setBackground(new java.awt.Color(100, 100, 100));
            }
        } else if (colModelId == 5) { // << you mean to check if the model index is 5 here
            if (Integer.parseInt(table.getModel().getValueAt(rowModelId, 5).toString()) >= 3) { // << when indexing the model, use model indexes
                c.setBackground(new java.awt.Color(20, 200, 20));
            }
            // << provide ELSE part here, eg:
            else {
                c.setBackground(new java.awt.Color(100, 100, 100));
            }
        } else {
            c.setBackground(new java.awt.Color(100, 100, 100));
        }

        return c;
    }
}