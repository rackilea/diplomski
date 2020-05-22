nameColumn.setCellValueFactory((p)->{
        String[] x = p.getValue();
        return new SimpleStringProperty(x != null && x.length>0 ? x[0] : "<no name>");
});

valueColumn.setCellValueFactory((p)->{
        String[] x = p.getValue();
        return new SimpleStringProperty(x != null && x.length>1 ? x[1] : "<no value>");
});