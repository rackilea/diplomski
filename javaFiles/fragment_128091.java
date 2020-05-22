public TreeModel<FileObject> getTreeModel() {
    if (treeModel == null) {
        try {
            FileSystemManager fsManager = VFS.getManager();
            FileObject fo = fsManager.resolveFile( FILE_SYSTEM_URI );
            treeModel = new CachingVfsTreeModel(fo);
        } catch (FileSystemException e) {
            throw new IllegalArgumentException(String.format("Could not open VFS uri: %s",FILE_SYSTEM_URI),e);
        }
        }
    return treeModel;
}