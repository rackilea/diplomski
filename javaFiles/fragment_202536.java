public void createPartControl(Composite parent) {
    ...
    final Action a = new Action("") {};
    final MenuManager mgr = new MenuManager();
    mgr.setRemoveAllWhenShown(true);

    mgr.addMenuListener(new IMenuListener() {
        public void menuAboutToShow(IMenuManager manager) {
         final IStructuredSelection selection = (IStructuredSelection) listViewer
                        .getSelection();
        if (!selection.isEmpty()) {
                       // example Action, here delete...
            Action deleteAction = new Action("Delete") {
              public void run() {
              ....      
                              }
            };
            mgr.add(deleteAction);

                       // *** decide here which actions to add by  ***
                       // *** evaluation of some of your variables ***

            mgr.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));

        }
        });
        tableViewer.getControl().setMenu(
                mgr.createContextMenu(tableViewer.getControl()));
....
}