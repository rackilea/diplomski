private Tbl getSampleTable(WordprocessingMLPackage wPMLpackage) {

    ObjectFactory factory = Context.getWmlObjectFactory();
    int writableWidthTwips = wPMLpackage.getDocumentModel().getSections()
                                        .get(0).getPageDimensions()
                                        .getWritableWidthTwips();
    List<Map<String, String>> data = getSampleTableData();
    TableDefinition tableDef = getSampleTableDef();
    int cols = tableDef.getColumns().size();
    int cellWidthTwips = new Double(
            Math.floor((writableWidthTwips / cols))
        ).intValue();

    Tbl table = TblFactory.createTable((data.size() + 1), cols, cellWidthTwips);

    Tr headerRow = (Tr) table.getContent().get(0);

    int f = 0;
    for (Column column : tableDef.getColumns()) {
        Tc column = (Tc) headerRow.getContent().get(f);
        P columnPara = (P) column.getContent().get(0);
        f++;
        Text text = factory.createText();
        text.setValue(column.getName());
        R run = factory.createR();
        run.getContent().add(text);
        columnPara.getContent().add(run);
    }
    int i = 1;

    for (Map<String, String> entry : data) {
        Tr row = (Tr) table.getContent().get(i);
        i++;
        int d = 0;
        for (String key : entry.keySet()) {
            Tc column = (Tc) row.getContent().get(d);
            P columnPara = (P) column.getContent().get(0);
            d++;
            Text tx = factory.createText();
            R run = factory.createR();
            tx.setValue(entry.get(key));
            run.getContent().add(tx);
            columnPara.getContent().add(run);
        }
    }
    return table;
}