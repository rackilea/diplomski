static void displayBFS(NaryTreeNode root) {
    int curlevel = 1;
    int nextlevel = 0;

    LinkedList<NaryTreeNode> queue = new LinkedList<NaryTreeNode>();
    queue.add(root);

    while(!queue.isEmpty()) { 
        NaryTreeNode node = queue.remove(0);

        if (curlevel == 0) {
            System.out.println();
            curlevel = nextlevel;
            nextlevel = 0;
        }

        for(NaryTreeNode n : node.nary_list) {
            queue.addLast(n);
            nextlevel++;
        }

        curlevel--;
        System.out.print(node.data + " ");
    } 
}