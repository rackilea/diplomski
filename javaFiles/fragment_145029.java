public static int getLevelSum(Node root, int N) {
    // Safe guard, probably redundant.
    if (N <= 0) {
        throw new IllegalArgumentException("N must be positive");
    }

    // We're at the level we want to sum, return the value
    if (N == 1) {
        return root.getValue();
    }

    int sum = 0;
    for (Node child : root.getChildren()) {
        sum += getLevelSum (child, N - 1);
    }
    return sum;
}