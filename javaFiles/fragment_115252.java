private void createSectionToolbar(Section section, FormToolkit toolkit) {
    ToolBarManager toolBarManager = new ToolBarManager(SWT.FLAT);

    ToolBar toolbar = toolBarManager.createControl(section);

    final Cursor handCursor = Display.getCurrent().getSystemCursor(SWT.CURSOR_HAND);
    toolbar.setCursor(handCursor);

    // Add sort action to the tool bar
    fSortAction = new SortAction(fImportViewer, PDEUIMessages.RequiresSection_sortAlpha, null, null, this);
    toolBarManager.add(fSortAction);

    toolBarManager.update(true);

    section.setTextClient(toolbar);
}