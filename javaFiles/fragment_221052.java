public class MyTreeNode extends DefaultMutableTreeNode {

    public int ID;

    public void setID(int ID) {
        this.ID = ID;
    }

    public MyTreeNode(String title) {
        setUserObject(title);
    }
}