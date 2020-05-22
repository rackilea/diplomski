table = new JTable(model) {

        /** 
         * @inherited <p>
         */
        @Override
        public JPopupMenu getComponentPopupMenu() {
            Point p = getMousePosition();
            // mouse over table and valid row
            if (p != null && rowAtPoint(p) >= 0) {
                // condition for showing popup triggered by mouse
                if (isRowSelected(rowAtPoint(p))) {
                    return super.getComponentPopupMenu();
                } else {
                    return null;
                }
            }
            return super.getComponentPopupMenu();
        }

    };