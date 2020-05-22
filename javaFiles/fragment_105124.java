public synchronized RowIterator getRows() throws RepositoryException {
        if (rowIterator != null) {
            RowIterator iterator = rowIterator;
            rowIterator = null;
            return iterator;
        } else {
            throw new RepositoryException(
                    "This query result has already been iterated through");
        }
}