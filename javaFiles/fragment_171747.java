public static int rowh, colh;//global 
...

table.addMouseMotionListener(new MouseAdapter() {
        @Override
        public void mouseMoved(MouseEvent e) {
            int row = table.rowAtPoint(e.getPoint());
            int col = table.columnAtPoint(e.getPoint());

            if (rowh != row || colh != col) { //movements from cell to cell inside the table. 
                rowh = row;
                colh = col;
                Object value = table.getModel().getValueAt(row, col);//get your Object value

                TableCellRenderer cellRenderer = table.getCellRenderer(row, col);
                Component rendererComponent = cellRenderer.getTableCellRendererComponent(table, null, false, true, row, col);
                JComponent jcomp = (JComponent)rendererComponent;

                //set the toolTip as you want.
                T bo = (T) (((DefaultTableModel) table.getModel()).getBusinessObject(row));
                    if (bo.getImageLink() != null) {
                        jcomp.setToolTipText(getImageFile(bo.getImageLink()));
                    } else {
                        jcomp.setToolTipText(null);
                    }
            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            rowh = -1;
            colh = -1;
        }
    });