@Override
protected void pageChange(int newPageIndex) {
    List<IWorkbenchPart> views = ... // find all opened IWorkbenchPart
    if (!views.isEmpty()) {
        views.get(0).setFocus();
        this.setFocus();
    }
    super.pageChange(newPageIndex);
}