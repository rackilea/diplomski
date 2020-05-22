public class CustomTreeItem extends TreeItem {
    @Override
    public void setState(boolean open, boolean fireEvents) {
        //check if we want to allow the item to close
        if (!open && !mayClose()) {
            return;
        }
        super.setState(boolean open, boolean fireEvents);
    }
    /**
     * Returns true if the item may be closed, due to some specific rules
     */
    public boolean mayClose() {
        // your check goes here
    }
}