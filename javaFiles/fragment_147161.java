public class Parser {
    enum FileType {
        UNHANDLED,
        XML,
        BINARY
    }

    public FileType getFileType(){
        return this.fileType;
    }

    private FileType fileType = FileType.XML;

    public Parser(){
    }
}