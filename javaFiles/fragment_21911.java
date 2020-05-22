public static int closest(Node<Integer, Person> node, int distanceToTarget, int target, int result) {
    if (node != null) {
        int newDistance = target - node.key;

        if (Math.abs(newDistance) > Math.abs(distanceToTarget)) {
            // If previous result was closer
            return result;
        } else if (newDistance > 0) {
            return closest(node.rightChild, newDistance, target, node.key);
        } else if (newDistance < 0) {
            return closest(node.leftChild, newDistance, target, node.key);
        }
    }

    return result;
}