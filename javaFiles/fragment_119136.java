public class TreeNode imlpements Serializable {

    private FileSystemEntry data;
    private boolean directory;
    private TreeNode parent;
    private ArrayList<TreeNode> children;
    private int numChildren;
    private int key;

}

public class DirectoryTree imlpements Serializable {

    private TreeNode Root;
    private int numNodes;
    private TreeNode Focus;
    private LocalDateTime date;
    private long totalSizeOnDisk;

}

public class FileSystemEntry imlpements Serializable {

    private Path path;
    private String name;
    private long sizeOnDisk;
    private FileTime created;
    private FileTime lastModified;

}