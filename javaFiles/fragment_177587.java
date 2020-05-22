header.addMouseListener(new MouseAdapter() {

        @Override
        public void mouseClicked(MouseEvent e) {
            JTableHeader h = (JTableHeader) e.getSource();
            int i = h.columnAtPoint(e.getPoint());
            Object o = h.getColumnModel().getColumn(i).getHeaderValue();
            if (i < 0 || o == selectedColumn) {
                selectedColumn = null;
                return;
            }
            selectedColumn = o;
            h.requestFocusInWindow();
        }
    });