public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
            Component c = super.prepareRenderer(renderer, row, column);

            if ((column == 2 || column == 3) && (Boolean)getValueAt(row, 0)) {
                return c;
            }

        //    if (column == 0 || column == 1 || (Boolean) getValueAt(row, 0)) {
            if (column == 0 || column == 1) {
                return c;
            }

            return Box.createRigidArea(c.getPreferredSize());
        }