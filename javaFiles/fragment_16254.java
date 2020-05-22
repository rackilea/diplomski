public Node IDS(Node root) {
        // loops through until a goal node is found
        for (int depth = 0; depth < Integer.MAX_VALUE; depth++) {
            Node found = DLS(root, depth);
            if (found != null) {
                return found;
            }
        }
        // this will never be reached as it 
        // loops forever until goal is found
        return null;
    }