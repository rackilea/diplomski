public void delte_raw(int raw) {
    if (!ls.isEmpty()) {
        this.fireTableRowsDeleted(raw+1, raw); // why raw+1 ???
        ls.remove(raw);
    }
}