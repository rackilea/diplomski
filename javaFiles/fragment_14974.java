int size = list.size();
for (int i = 0; i < size; ++i) {
    final MyClass current = list.get(i);
    for (int j = 0; j < i; ++j) {
        final MyClass previous = list.get(j);
        final int relation = previous.relationTo(current);
        if (relation < 0) {
            // remove previous (at index j)
            list.remove(j);
            --i;
            --j;
            --size;
        } else if (relation > 0) {
            // remove current (at index i)
            list.remove(i);
            --i;
            --size;
            break; // exit inner loop
        }
        // else current and previous don't share a prefix
    }
}