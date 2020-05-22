getOutline().getColumnModel().addColumnModelListener(new TableColumnModelListener() {

        @Override
        public void columnAdded(TableColumnModelEvent tcme) { }

        @Override
        public void columnRemoved(TableColumnModelEvent tcme) { }

        @Override
        public void columnMoved(TableColumnModelEvent tcme) {


            /* Must be done with invoke later, since    
             * this will be called when the user clicks on the column, not
             * when the actual sorting takes place...
             */
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    getSortedNodes();
                }
            });
        }

        @Override
        public void columnMarginChanged(ChangeEvent ce) { }

        @Override
        public void columnSelectionChanged(ListSelectionEvent lse) { }
    });


private List<Node> getSortedNodes() {
        List<Node> sortedNodes = new ArrayList<>();
        for (int i = 0; i < getOutline().getRowCount(); i++) {
            int sortedIndex = getOutline().convertRowIndexToModel(i);
            ETable.RowMapping mapping = new ETable.RowMapping(sortedIndex, getOutline().getModel(), getOutline());
            Node node = (Node) mapping.getTransformedValue(0);
            sortedNodes.add(node);
        }
        return sortedNodes;
    }