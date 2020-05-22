cell.textProperty().bind(Bindings.createStringBinding(() -> {
    if (cell.isEmpty()) {
        return "" ;
    } else {
        return String.format("%s", cell.getItem());
    }
}, cell.itemProperty(), cell.emptyProperty());