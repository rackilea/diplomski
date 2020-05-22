public static void algorithm(Node root) {
    Queue<Node> q = new LinkedList<>();
    q.add(root);

    while(!q.isEmpty()) {
        Node current = q.poll();

        if(current .getData().toString().toUpperCase().contains("BRANCH")) {
            continue;
        }

        if(condition){
            //some processing
            return;
        } else {
            q.addAll(current.getChildren());
        }
    }
}