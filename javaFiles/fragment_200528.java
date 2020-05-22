class FileNode {

    private String name;
    private String type;
    private List<FileNode> children;
    private List<String> content;

    public List<String> findContent(String name) {
        LinkedList<FileNode> queue = new LinkedList<>();
        queue.add(this);
        while (queue.size() > 0) {
            FileNode next = queue.pop();
            if (next.name.equals(name)) {
                return next.content;
            }
            if (next.children != null) {
                queue.addAll(next.children);
            }
        }

        return Collections.emptyList();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<FileNode> getChildren() {
        return children;
    }

    public void setChildren(List<FileNode> children) {
        this.children = children;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "FileNode{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", children=" + children +
                ", content=" + content +
                '}';
    }
}