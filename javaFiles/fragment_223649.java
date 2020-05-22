private final static String DEFAULT_FOLDER_NAME = "${user.home}";
@Option(name = "-readFromFolder",usage = "specifies a folder containing files to read")
private String folderName;

public String getFolderName() {
    return null == folderName ? DEFAULT_FOLDER_NAME : folderName ;
}