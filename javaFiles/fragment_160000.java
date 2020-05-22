Set<Long> set = new HashSet<Long>();
for (i = 0; i < b.length - 1; i++) {
    for (int j = i + 1; j < b.length; j++) {
        if ((b[i] == (b[j])) && (i != j)) {
            set.add(b[j]);
        }
    }
}
for (Long result: set) {
    System.out.println(result);
}