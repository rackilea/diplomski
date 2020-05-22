table.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            // This is for double click event on anywhere on JTable
            if (e.getClickCount() == 2) {
                JTable target = (JTable) e.getSource();
                int row = target.getSelectedRow();
                int column = target.getSelectedColumn();
               // you can play more here to get that cell value and all
                new DialogYouWantToOpen(row, Column);
            }
        }

    });