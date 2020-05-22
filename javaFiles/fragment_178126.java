class ResultSetIterator implements Iterator<ResultSet> {

    private final ResultSet r;
    private ResultSet next = null;

    public ResultSetIterator(ResultSet r) {
        this.r = r;
    }

    @Override
    public boolean hasNext() {
        if (next == null) {
            try {
                if (r.next()) {
                    next = r;
                }
            } catch (SQLException ex) {
                // NB: Log this error.
            }
        }
        return next != null;
    }

    @Override
    public ResultSet next() {
        ResultSet n = next;
        next = null;
        return n;
    }

}