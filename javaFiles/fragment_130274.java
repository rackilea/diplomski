public void delte_raw(int raw) {
    if (!ls.isEmpty()) {            
        ls.remove(raw); // remove the row index from the List and then fire the event
        fireTableRowsDeleted(raw, raw);
    }
}