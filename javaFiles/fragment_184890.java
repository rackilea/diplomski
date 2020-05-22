public static void main(String[] args){
    FileStorage fileStorage = new FileStorage();

    // User create a new file
    File file1 = new File();

    fileStorage.addNewFile(file1, "file1"); // name can also be file1.getName()

    [...]

    // Later you can access the file
    File storedFile = fileStorage.getStoredFile("file1");
}