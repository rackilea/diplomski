@Override
public boolean isCellEditable(EventObject anEvent) {
    if (anEvent instanceof MouseEvent) {
        return ((MouseEvent) anEvent).getClickCount() >= clickCountToStart;
    }
    return true;
}