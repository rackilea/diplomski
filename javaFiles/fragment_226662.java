@Override
public void setVisible(boolean b) {
    super.setVisible(b);
    if (b) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                tbl.editCellAt(tbl.getRowCount() - 1, tbl.getColumnCount() - 1);
                tbl.getEditorComponent().requestFocusInWindow();
            }
        });
    }
}