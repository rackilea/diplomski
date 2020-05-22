TreeSet<String> set = new TreeSet<>(
        Arrays.asList("a", "z", "b", "y"));
    String cur;

    cur = set.first();     // a
    cur = set.higher(cur); // b
    cur = set.higher(cur); // y
    cur = set.higher(cur); // z
    cur = set.lower(cur);  // y
    cur = set.lower(cur);  // b
    cur = set.lower(cur);  // a
    cur = set.lower(cur);  // null