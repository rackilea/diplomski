void breadthFirstInsert(Node root, Object obj) {
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()) {
        Node temp = queue.poll();
        if(temp.left != null) {
            queue.offer(temp.left);
        } else {
            temp.left = new Node(obj);
            return;
        }
        if(temp.right != null) {
            queue.offer(temp.right);
        } else {
            temp.right = new Node(obj);
            return;
        }
    }
}