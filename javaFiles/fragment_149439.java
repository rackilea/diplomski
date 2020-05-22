/**
     * Returns an iterator for this index set
     * @return Iterator<IndexRequest> An iterator for this index set
     */
    public Iterator<IndexRequest> iterator() {
        if (iterable == null) {
            initIterable();
        }
        return iterable.values().iterator();
    }