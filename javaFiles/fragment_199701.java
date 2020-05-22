public void addSelectionListener(SelectionListener listener) {
    addListener(SWT.Selection, new TypedListener(listener));
}

public void removeSelectionListener(SelectionListener listener) {
    removeListener(SWT.Selection, listener);
}