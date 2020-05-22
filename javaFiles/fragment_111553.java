table.addListener(SWT.MenuDetect,new Listener() {
        @Override
        public void handleEvent(Event e) {
            Point ptAbsolute = new Point(e.x, e.y);
            Point pt = table.toControl(ptAbsolute); 
            int colIndex = columnAtPoint(table, pt);
            if (colIndex >= 0) {
                if (pt.y < table.getHeaderHeight())  {  
                    // Negative Y means table header

                    System.out.println("Column name is " + table.getColumn(colIndex).getText());
                } 
                else {
                    System.out.println("Row right-clicked on column name is " + table.getColumn(colIndex).getText());
                }
            }
        }
});