public void sort(Comparator<? super T> comparator) {
        // Get them all out - not sure why you have a parameter to `asList`
        List<T> all = asList(Collections.emptyList());
        // Sort them.
        Collections.<T>sort(all);
        // Clear completely.
        dataStart = dataEnd = 0;
        addAll(all);
    }