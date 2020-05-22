cursorAdapter.setFilterQueryProvider(new FilterQueryProvider() {
    public Cursor runQuery(CharSequence constraint) {
        getCons.open();
        return getCons.getChanges(constraint.toString());
    }
});