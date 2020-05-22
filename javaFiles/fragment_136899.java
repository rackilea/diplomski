public class NaryTree {
    static HashMap<String, NaryTree.Node> tree = new HashMap<String, NaryTree.Node>();  

    public static void main(String[] args) {
        new NaryTree().makeTree();  
        traverseFrom(tree.get("000"));
    }

    public static void traverseFrom(Node rootNode)  {       
        if(rootNode.getChildren().size()!= 0) {
            for (Node pNode : rootNode.getChildren()) {             
                System.out.println(" Lavel:"+pNode.lavel+" - Node Value:"+pNode.val); // preorder traverse              
                traverseFrom(pNode);
                //System.out.print(" Lavel :"+pNode.lavel+"- Node Value :"+pNode.val); // preorder traverse
            }           
        }       
    }

    private void  makeTree() {

        Node newNode = new Node("000", null, new ArrayList<NaryTree.Node>());
        newNode.setLavel(0);
        tree.put("000", newNode);       
        //newNode.getParent().getChildren().add(newNode);

        newNode = new Node("101", tree.get("000"), new ArrayList<NaryTree.Node>());
        tree.put("101", newNode);
        newNode.getParent().getChildren().add(newNode);

        newNode = new Node("102", tree.get("000"), new ArrayList<NaryTree.Node>());
        tree.put("102", newNode);
        newNode.getParent().getChildren().add(newNode);

        newNode = new Node("103", tree.get("000"), new ArrayList<NaryTree.Node>());
        tree.put("103", newNode);
        newNode.getParent().getChildren().add(newNode);

        newNode = new Node("201", tree.get("101"), new ArrayList<NaryTree.Node>());
        tree.put("201", newNode);
        newNode.getParent().getChildren().add(newNode);

        newNode = new Node("202", tree.get("101"), new ArrayList<NaryTree.Node>());
        tree.put("202", newNode);
        newNode.getParent().getChildren().add(newNode);

        newNode = new Node("205", tree.get("103"), new ArrayList<NaryTree.Node>());
        tree.put("205", newNode);
        newNode.getParent().getChildren().add(newNode);

        newNode = new Node("301", tree.get("201"), new ArrayList<NaryTree.Node>());
        tree.put("301", newNode);
        newNode.getParent().getChildren().add(newNode);

        newNode = new Node("104", tree.get("000"), new ArrayList<NaryTree.Node>());
        tree.put("104", newNode);
        newNode.getParent().getChildren().add(newNode);
    }

 private class Node {

        private String val;
        private int lavel;
        private Node parent;
        private List<Node> children;

        public Node(String val, Node parent, List<Node> children) {
            this.val = val;
            this.parent = parent;
            this.children = children;
            if(parent!=null)
                this.lavel = (int) parent.getLavel()+1;
            else 
                this.lavel = 0;
        }

        public String getVal() {
            return val;
        }
        public void setVal(String val) {
            this.val = val;
        }
        public Node getParent() {
            return parent;
        }
        public void setParent(Node parent) {
            this.parent = parent;
        }
        public List<Node> getChildren() {
            return children;
        }
        public void setChildren(List<Node> children) {
            this.children = children;
        }

        public int getLavel() {
            return lavel;
        }

        public void setLavel(int lavel) {
            this.lavel = lavel;
        }
    }
}