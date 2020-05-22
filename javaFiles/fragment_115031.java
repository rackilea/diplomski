class FileData {
    private static final FileData instance = readFile();
    public static FileData getInstance() {
         return instance;
    }
    private static readFile() {
        ... // Read the file, and create FileData from it
    }
    public int getImportantNumber() {
        return ...
    }
}