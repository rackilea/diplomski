private void setRowHight(TableView t1, TableView t2) {
    List<Node> leftTableRows = new ArrayList(t1.lookupAll(".table-row-cell"));
    List<Node> rightTableRows = new ArrayList(t2.lookupAll(".table-row-cell"));

    for (Node tableRow : rightTableRows) {
        TableRow<?> r = (TableRow<?>) tableRow;
        for (Node tableRowLeft : leftTableRows) {
            TableRow<?> l = (TableRow<?>) tableRowLeft;
                if (r.getIndex() == l.getIndex()) {
                    l.setPrefHeight(r.getHeight());
                    break;
                }
            }
    }    
}