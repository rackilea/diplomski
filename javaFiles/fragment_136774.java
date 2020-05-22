Accessible a = fontsBox.getUI().getAccessibleChild(fontsBox, 0);
    if (a instanceof javax.swing.plaf.basic.ComboPopup) {
        JList list = ((javax.swing.plaf.basic.ComboPopup)a).getList();
        Rectangle rect = list.getVisibleRect();
        int first = list.locationToIndex(rect.getLocation());
        // similar for last, at the lower edge of the visible rect, left as exercise <g>
        // Edit: as of @Boro's comment, last is easier calculated with maxRowCount
        int last = first + fontsBox.getMaximumRowCount() - 1;
        ....