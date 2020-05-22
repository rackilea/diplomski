public class PopUpMenu extends JPopupMenu {
    private Container parent;

    public PopUpMenu(MenuItem[] menuItems) {
        super();
        for (MenuItem item : menuItems) {
            add(item);
        }
    }

    public void setParent(Container parent) {
        this.parent = parent;
        parent.addMouseListener(new PopUpListener(this));
    }

}