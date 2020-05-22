class Category {
    private List<SubCategory> children = new ArrayList<SubCategory>();

    public List<SubCategory> getSubCategories() {
        return children;
    }

    public void addSubCategory(SubCategory child) {
        child.setParent(this);
        children.add(child);
    }

    public Category getParent() {
        return null;
    }
}

class SubCategory extends Category {
    private Category parent = null;

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }
}