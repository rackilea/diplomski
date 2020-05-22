private static final class SimpleCollector extends Collector {
    final Set<Integer> docs = CollectionHelper.newHashSet();
    int docBase;

    @Override
    public void setScorer(Scorer scorer) throws IOException {
        // no scoring
    }

    @Override
    public void collect(int doc) throws IOException {
        docs.add(docBase + doc);
    }

    @Override
    public void setNextReader(AtomicReaderContext context) throws IOException {
        this.docBase = context.docBase;
    }

    @Override
    public boolean acceptsDocsOutOfOrder() {
        return true;
    }

}