public static class FolderTreeModel implements TreeViewModel {
    private final ListDataProvider<Folder> dataProvider;
    private final CellPreviewEvent.Handler<Folder> folderSelectionHandler;

    public FolderTreeModel(List<Folder> folders, CellPreviewEvent.Handler<Folder> folderSelectionHandler) {
        this.folderSelectionHandler = folderSelectionHandler;
        dataProvider = new ListDataProvider<Folder>(folders);
    }

    @Override
    public <T> TreeViewModel.NodeInfo<?> getNodeInfo(T value) {
        return new DefaultNodeInfo<Folder>(dataProvider, new AbstractCell<Folder>() {
            // simple renderer that renders folder name
            @Override 
            public void render(Context context, Folder value, SafeHtmlBuilder sb) {
                sb.appendEscaped(value.getName());
            }
        }, 
        new SingleSelectionModel<Folder>(), // using single selection model
        folderSelectionHandler, // add handler to the node info
        null); // value updater can be null
    }

    @Override
    public boolean isLeaf(Object value) {
        return false; // I will say that every node is not leaf for simplicity 
    }
 }