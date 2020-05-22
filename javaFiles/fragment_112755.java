adapter.setFilterQueryProvider(new FilterQueryProvider() {
        public Cursor runQuery(CharSequence constraint) {
            // Search for states whose names begin with the specified letters.
            c = db.getFilterCursor(constraint);
            return c;
        }
    });