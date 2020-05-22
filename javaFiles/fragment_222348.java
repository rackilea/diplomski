public void addFolder() {

    round(printSize, 1);
    folderTable.setItems(getSyncedFolders());
    folderTable.getItems().add(new syncedFolders(name, location, dateModified, tempSize));
}