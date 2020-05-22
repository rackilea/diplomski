class BST<T> {
    T value;
    BST<T> left;
    BST<T> right;

    public BST(T[] contents) {
        insert(contents);
    }

    private void insert(T[] contents) {
        if (contents.length > 0) {
            if (contents.length == 1) {
                value = contents[0];
            } else {
                // Split it.
                int center = contents.length / 2;
                // Take the center value as my value
                value = contents[center];
                if (center > 0) {
                    // There is more to the left so put it in my `left` branch.
                    left = new BST<>(Arrays.copyOfRange(contents, 0, center));
                }
                if (center < contents.length) {
                    // ditto to the right.
                    right = new BST<>(Arrays.copyOfRange(contents, center + 1, contents.length));
                }
            }
        }
    }

    public int size() {
        return (left != null ? left.size() : 0)
                + (value != null ? 1 : 0)
                + (right != null ? right.size() : 0);
    }

    @Override
    public String toString() {
        return (left != null ? left.toString() + "," : "")
                + (value != null ? value : "")
                + (right != null ? "," + right.toString() : "");
    }
}

private void test(Integer[] integers) {
    System.out.println("Array = " + Arrays.toString(integers) + " length " + integers.length);
    BST<Integer> bst = new BST<>(integers);
    System.out.println("BST = " + bst.toString() + " length " + bst.size());
}

private void test() {
    test(new Integer[]{5, 20, 25, 50, 66, 75, 80, 90, 92, 95, 111, 150, 166, 175, 200});
    test(new Integer[]{5, 20, 25, 50, 66, 75, 80, 90, 92, 95, 111, 150, 166, 175});
    test(new Integer[]{90});
    test(new Integer[]{});
}