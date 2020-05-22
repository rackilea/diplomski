public int traverseHelper(Node t, String key, int n) {
    if (t == null) {
        return n;
    } else {
        if (t.data.getTitle().indexOf(key) >= 0 && n <= 10) {
            System.out.println(t.data);
            n++;
        }
        return traverseHelper(t.left, key, traverseHelper(t.right, key, n));
    }
}