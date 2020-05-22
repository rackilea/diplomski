JTree t = new JTree();
    t.setEditable(true);
    TreeCellRenderer cellRenderer = t.getCellRenderer();
    DefaultTreeCellEditor cellEditor = new DefaultTreeCellEditor(t, (DefaultTreeCellRenderer) cellRenderer){
        @Override
        public boolean isCellEditable(EventObject arg0) {
            if(arg0 instanceof MouseEvent){
                return ((MouseEvent)arg0).getClickCount() > 2;
            }
            return super.isCellEditable(arg0);
        }
    };
    t.setCellEditor(cellEditor);