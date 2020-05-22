class Folder {
    private String name;
    private int id;
    private int parentId;
    private List<Folder> children = new ArrayList<Folder>();

    public Folder(String name, int id, int parentId) {
        this.name = name;
        this.id = id;
        this.parentId = parentId;
    }

    public void addChildFolder(Folder folder) {
        this.children.add(folder);
    }

    public List<Folder> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public int getParentFolderId() {
        parentId;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}