class SomeSpecialComponent extends JComponent implements HierarchyListener {

    private boolean amIVisible() {
        Container c = getParent();
        while (c != null)
            if (!c.isVisible())
                return false;
            else
                c = c.getParent();
        return true;
    }

    public void addNotify() {
        super.addNotify();
        addHierarchyListener(this);
    }

    public void removeNotify() {
        removeHierarchyListener(this);
        super.removeNotify();
    }

    public void hierarchyChanged(HierarchyEvent e) {
        System.out.println("Am I visible? " + amIVisible());
    }

}