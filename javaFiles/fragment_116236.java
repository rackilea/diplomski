public class MenuItem {
    private String id;
    private String label;
    private String link;
    private MenuItem parent;
    private final List<MenuItem> children = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public MenuItem getParent() {
        return parent;
    }

    public void setParent(MenuItem parent) {
        this.parent = parent;
    }

    public List<MenuItem> getChildren() {
        return new ArrayList<>(children);
    }

    public void addChild(MenuItem child) {
        children.add(child);
    }
}