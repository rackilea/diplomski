table = new JTable(model) {
        @Override
        public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
            Component comp = super.prepareRenderer(renderer, row, column);
            int modelRow = convertRowIndexToModel(row);
            Float sinh = (Float) getModel().getValueAt(modelRow, 2);
            Float kol = (Float) getModel().getValueAt(modelRow, 1);
            comp.setBackground(kol.equals(sinh) ? getBackground() : Color.YELLOW);
            return comp;
        }
    };