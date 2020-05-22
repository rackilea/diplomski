class TwoDimIterator implements Iterator<String> {

    Iterator<Map<String, String>> outerIter;
    Iterator<String> innerIter = Collections.<String>emptyList().iterator();

    public TwoDimIterator(Map<String, Map<String, String>> twoDimMap) {
        outerIter = twoDimMap.values().iterator();
        advanceInner();
    }

    @Override
    public boolean hasNext() {
        return innerIter.hasNext();
    }

    @Override
    public String next() {
         String toReturn = innerIter.next();
         advanceInner();
         return toReturn;
    }

    private void advanceInner() {
        while (!innerIter.hasNext()) {
            if (!outerIter.hasNext()) {
                innerIter = Collections.<String>emptyList().iterator();
                return;
            }
            innerIter = outerIter.next().values().iterator();
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}