PseudoClass enableRowClass = PseudoClass.getPseudoClass("enabled-row");

setRowFactory(tv -> {
                TableRow<Media> row = new TableRow<>();

                // use EasyBind to access the valueProperty of the itemProperty
                // of the cell:
                row.disableProperty().bind(
                        // start at itemProperty of row
                        EasyBind.select(row.itemProperty())
                                // map to fileExistsProperty[a boolean] of item, if item
                                // non-null
                                .selectObject(Media::fileExistsProperty)
                                // map to BooleanBinding checking if false
                                .map(x -> x.booleanValue() == false)
                                // value to use if item was null
                                .orElse(false));

  //This line of code is the idea of the `Harshita Sethi` modified a little bit to not use a changelistener
  row.pseudoClassStateChanged(enableRowClass, !row.disabledProperty().get());

    return row;
 });