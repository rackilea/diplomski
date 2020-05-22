new Comparator<Table>() {
    @Override public int compare(Table one, Table two) {
        return ComparisonChain.start()
                 .compare(one.getTableName(), two.getTableName())
                 .compare(one.hashCode(), two.hashCode())
                 .result();
    }
}