private static void isChild(Path child, String parentText) {
    Path parent = Paths.get(parentText).toAbsolutePath();
    System.out.println(parentText + " = " + child.startsWith(parent));
}

public static void main(String[] args) {
    Path child = Paths.get("/FolderA/FolderB/File").toAbsolutePath();
    isChild(child, "/FolderA/FolderB/File");
    isChild(child, "/FolderA/FolderB/F");
    isChild(child, "/FolderA/FolderB");
    isChild(child, "/FolderA/Folder");
    isChild(child, "/FolderA");
    isChild(child, "/Folder");
    isChild(child, "/");
    isChild(child, "");
}