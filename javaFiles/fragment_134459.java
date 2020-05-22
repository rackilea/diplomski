HighlightPredicate spakowany = new HighlightPredicate() {
        @Override
        public boolean isHighlighted(Component renderer, ComponentAdapter adapter) {
            TableModel tableModel = table.getModel();
            if (tableModel instanceof StanTableModel) {
                StanTableModel stanTableModel = (StanTableModel) tableModel;
                // int rowIndex = adapter.row;  <-  this was the issue 
                int rowIndex = adapter.convertRowIndexToModel(adapter.row);
                StanTableRow myCustomRow = stanTableModel.getRow(rowIndex);
                if ((myCustomRow.isSpakowany()) {
                    return true;
                }
            }
            return false;
        }
    };