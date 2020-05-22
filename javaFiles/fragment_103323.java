MenuManager manager = new MenuManager();
viewer.getControl().setMenu(manager.createContextMenu(viewer.getControl()));

manager.add(new Action("MENU ITEM TEXT", ImageDescriptor.createFromImage(YOUR_IMAGE)) {
    @Override
    public void run() {
        // get the current selection of the tableviewer
        IStructuredSelection selection = (IStructuredSelection) viewer.getSelection();
        // do something
    }
});