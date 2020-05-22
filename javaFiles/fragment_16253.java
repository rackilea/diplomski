public Node DLS(Node current, int depth) {
        if (depth == 0 && current == goal) {
            return current;
        }
        if (depth > 0) {
            for (Node child : current.findNeighbours()) {
                Node found = DLS(child, depth - 1);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }