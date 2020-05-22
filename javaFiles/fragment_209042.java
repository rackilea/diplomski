public static class BinderOwner {
    @UiField(provided = true)
    CellTree folderTree;
    @UiField
    Label folderName; //your other UI element that you will change: show the name of selected folder

    public BinderOwner() {
         //List of folders to show something
         ArrayList<Folder> folders = new ArrayList<Folder>();
         folders.add(new Folder("A"));
         folders.add(new Folder("B"));
         folders.add(new Folder("C"));

         // define folder tree
         folderTree = new CellTree(new FolderTreeModel(folders, new CellPreviewEvent.Handler<Folder>() {
             // this is your handler
             @Override 
             public void onCellPreview(CellPreviewEvent<Folder> event) {
                 // set folder name to label on folder selection
                 folderName.setText(event.getValue().getName());
             }
         }), null);
    }
}