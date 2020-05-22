public static char[] flopChild(final char[] a, final char[] b) {
    final Random r = new Random();
    int y = 0;
    final ArrayList<Integer> parts = new ArrayList<Integer>();
    final char[] child = new char[geneSize];

    while (y < geneSize) { // Break it into parts so you can easily swap
                            // genes from the parents
        final int num = r.nextInt(geneSize + 1 - y);
        if (num + y > geneSize) {
            parts.add(num + y - geneSize);
            y = geneSize + 1;
        } else {
            if (num == 0) {
            } else {
                parts.add(num);
                y += num;
            }
        }
    }

    int last = 0;
    for (int x = 0; x < parts.size(); x++) { // Use the pieces to get chunks
                                                // from the parents var a
                                                // and b
        final int next = last + parts.get(x);
        final char[] parent = r.nextInt(2) == 0 ? a : b; /*
                                                         * You want the same
                                                         * parent for one
                                                         * given chunk,
                                                         * right?
                                                         */
        for (int z = last; z < next; z++) {
            child[z] = parent[z];
        }
        last = next; // And not parts.get(x)
    }
    return child;
}