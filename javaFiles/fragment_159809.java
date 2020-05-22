class Tree<ContentType extends Comparable<ContentType>>{

    // here
    Node<ContentType> node;

    public Tree(){
        node = null;
    }

    public Tree(ContentType pContent){
        node = new Node<ContentType>(pContent);
    }

    // each time Tree is used, it should be typed!
    public Tree(ContentType pContent, Tree<ContentType> pLeftTree, Tree<ContentType> pRightTree){
        // same with Node!
        node = new Node<ContentType>(pContent);
        node.setLeftTree(pLeftTree);
        node.setRightTree(pRightTree);
    }

    //Node needs to be typed with the exact same type as Tree!
    private class Node<ContentType extends Comparable<ContentType>>{
        // Typed Tree!
        Tree<ContentType> left = null;
        Tree<ContentType> right = null;
        ContentType content = null;


        public Node(ContentType pContent){
            content=pContent;
            left = new Tree<ContentType>();
            right = new Tree<ContentType>(); 
        }

        public void setLeftTree(Tree<ContentType> tree) {
            left = tree;
        }

        public void setRightTree(Tree<ContentType> tree) {
            right = tree;
        }
    }
}