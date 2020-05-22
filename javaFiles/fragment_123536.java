final JTable orderTable = new JTable(dataModel);
    // All columns with class Boolean are renderered with MyFancyItemRenderer
    orderTable.setDefaultRenderer(Boolean.class, new MyFancyItemRenderer());

    // Setting the cell renderers explicitly for each column
    final TableColumnModel columnModel = orderTable.getColumnModel();

    final TableColumn itemCountColumn = columnModel.getColumn(ITEM_COUNT);
    itemCountColumn.setCellRenderer(new MyFancyItemRenderer());

    // ...

    final TableColumn sumColumn = columnModel.getColumn(SUM);
    sumColumn.setCellRenderer(new MyFancyPriceRenderer());