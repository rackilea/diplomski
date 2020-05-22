@Override
public boolean isCellEditable(EventObject aAnEvent) {
    boolean cellEditable = super.isCellEditable(aAnEvent);

    if (cellEditable && aAnEvent instanceof MouseEvent) {
        cellEditable = ((MouseEvent) aAnEvent).getClickCount() == 2;
    }

    return cellEditable;
}