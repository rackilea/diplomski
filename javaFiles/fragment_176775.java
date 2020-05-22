public class MyLeafNode extends DefaultMutableTreeNode{

    private String[] items;
    private String selected;

    public MyLeafNode(String name, String...items){
        super(name);
        this.items = items;
        this.selected = items[0];
    }

}