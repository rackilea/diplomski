// ...
    Vector<Integer> v = new Vector<>();
    // ...
    for (c = 0; c < (n - 1); c++) {
        for (d = 0; d < n - c - 1; d++) {
            if (v.get(d) > v.get(d + 1)) {
                swap = v.get(d);
                v.set(d, v.get(d + 1));
                v.set(d + 1, swap);
            }
        }
    }
    // ...