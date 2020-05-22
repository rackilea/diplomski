int N = A.length;
Set<Integer> set = new HashSet<>();
for (int a : A) {
    if (a > 0) {
        set.add(a);
    }
}
for (int i = 1; i <= N + 1; i++) {
    if (!set.contains(i)) {
        return i;
    }
}