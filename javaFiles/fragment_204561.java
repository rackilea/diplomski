class Pair<K, V> {
    K first;
    V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }
}

private static int longestPath(HashMap<String, List<String>> tree) {
    Stack<Pair<String, Integer>> stack = new Stack<>();
    stack.push(new Pair<String, Integer>("start", 0));
    int best = 0;

    while (!stack.isEmpty()) {
        Pair<String, Integer> current = stack.pop();

        if (current.first.equals("end")) {
            best = Math.max(current.second, best);
        }
        else {
            for (String child : tree.get(current.first)) {
                stack.push(
                    new Pair<String, Integer>(child, current.second + 1)
                );
            }
        }
    }

    return best;
}