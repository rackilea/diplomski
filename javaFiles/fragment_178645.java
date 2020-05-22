PseudoClass caution = PseudoClass.getPseudoClass("caution");

table.setRowFactory(tv -> {
    TableRow<Trade> row = new TableRow<>();

    ChangeListener<Boolean> cautionListener = (obs, wasCaution, isNowCaution) -> 
        row.pseudoClassStateChanged(caution, isNowCaution);

    row.itemProperty().addListener((obs, oldTrade, newTrade) -> {
        if (oldTrade != null) {
            oldTrade.cautionProperty().removeListener(cautionListener);
        }
        if (newTrade == null) {
            row.pseudoClassStateChanged(caution, false);
        } else {
            row.pseudoClassStateChanged(caution, newTrade.isCaution());
            newTrade.cautionProperty().addListener(cautionListener);
        }
    });

    return row ;
});