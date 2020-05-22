final DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
dlcr.setText("one of my combo items");

int numRows = (int)( (1.0f * frame.getHeight()) / dlcr.getPreferredSize().height );

setMaximumRowCount(numRows);