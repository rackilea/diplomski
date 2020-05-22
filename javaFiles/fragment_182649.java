public void printLevelOrder(){
    Queue<Node> q = new LinkedList<Node>();
    Map<Node, Node> parents = new HashMap<Node,Node>();
    Node nextLevel = null;
    q.add(this);
    int lvl = 0;

    while (!q.isEmpty()){
        Node n = q.remove();
        if (n == nextLevel || nextLevel == null){
            System.out.print("\nlvl " + lvl++ +" ");
            nextLevel = null;
        }
        System.out.print("("+n.value +","+parents.remove(n)+")");
        if (n.left != null){
            q.add(n.left);
            parents.put(n.left, n);
            if (nextLevel == null)
                nextLevel = n.left;
        }
        if (n.right != null){
            q.add(n.right);
            parents.put(n.right, n);
            if (nextLevel == null)
                nextLevel = n.right;
        }
    }
}