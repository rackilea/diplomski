protected void pageChange(int newPageIndex) {
    boolean changingPages = this.changingPages;
    this.changingPages = true;
    int oldPageIndex = tabFolder.getSelectionIndex();

    if (isDirty() && !changingPages) {
        tabFolder.setSelection(oldPageIndex);

        if (canChangePages()) {
            tabFolder.setSelection(newPageIndex);
        }
    }

    this.changingPages = false;
}