static <E> boolean isOverText(Point location,
                              JList<E> list) {

    int index = list.locationToIndex(location);
    if (index < 0) {
        return false;
    }

    E value = list.getModel().getElementAt(index);
    ListCellRenderer<? super E> renderer = list.getCellRenderer();
    Component c = renderer.getListCellRendererComponent(list, value, index,
        list.isSelectedIndex(index),
        list.getSelectionModel().getLeadSelectionIndex() == index);

    if (c instanceof JLabel) {
        JLabel label = (JLabel) c;

        Icon icon = null;
        if (!label.isEnabled()) {
            icon = label.getDisabledIcon();
        }
        if (icon == null) {
            icon = label.getIcon();
        }

        Rectangle listItemBounds =
            SwingUtilities.calculateInnerArea(label, null);
        Rectangle cellBounds = list.getCellBounds(index, index);
        listItemBounds.translate(cellBounds.x, cellBounds.y);
        listItemBounds.width = cellBounds.width;
        listItemBounds.height = cellBounds.height;

        Rectangle textBounds = new Rectangle();
        Rectangle iconBounds = new Rectangle();

        SwingUtilities.layoutCompoundLabel(label,
            label.getFontMetrics(label.getFont()),
            label.getText(),
            icon,
            label.getVerticalAlignment(),
            label.getHorizontalAlignment(),
            label.getVerticalTextPosition(),
            label.getHorizontalTextPosition(),
            listItemBounds,
            iconBounds,
            textBounds,
            label.getIconTextGap());

        return textBounds.contains(location);
    }