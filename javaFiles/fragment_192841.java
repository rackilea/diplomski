class TabularSpliterator extends Spliterator.AbstractSpliterator<List<Object>> {
    private final TabularResultSet rs;

    public TabularSpliterator(TabularResultSet rs) {
        super(...);
        this.rs = rs;
    }

    @Override public boolean tryAdvance(Consumer<? super List<Object>> action) {
        if (rs.next()) {
            action.accept(rs.getData());
            return true;
        } else {
            return false;
        }
    }
}