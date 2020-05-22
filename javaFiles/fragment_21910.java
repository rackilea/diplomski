public static int closest(Node<Integer, Person> n1, int smallest, int key, int key1) {
    while (n1 != null) {
        int difference = key - n1.key;
        if (smallest == 0) {
            smallest = difference;
            key1 = n1.key;
            return closest(n1.rightChild, smallest, key, key1);
        } else {
            if (difference < smallest) {
                smallest = difference;
                key1 = n1.key;
                return closest(n1.leftChild, smallest, key, key1);
            }
        }
    }

    return key1;
}