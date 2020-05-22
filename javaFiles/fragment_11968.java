public class Parent {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Parent[] getChildren() {
        return children;
    }

    public void setChildren(Parent[] children) {
        this.children = children;
    }

    private String name;
    private String parent;
    private String type;
    private Parent[] children;
}