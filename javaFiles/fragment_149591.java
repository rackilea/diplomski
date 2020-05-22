for(Folder folder : data.values()) {
    int parentId = folder.getParentFolderId();
    Folder parentFolder = data.get(parentId);
    if(parentFolder != null)
        parentFolder.addChildFolder(folder);
}