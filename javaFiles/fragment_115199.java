public class ParentBean {
    /* ... */

    public void addChild(ChildBean child) {
        this.revisionList.add(child);
        child.setParent(this);
    }

    /* ... */
}