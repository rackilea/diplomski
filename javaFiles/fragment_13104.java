//create table columns
    Vector<String> categoryReportColumnNames = new Vector<>();
    categoryReportColumnNames.add("Categorías");
    categoryReportColumnNames.add("Ítems");

    //create table data
    Vector<Vector> categoryReportVector = controller.getDataVector();

    //setting the tabel model
    DefaultTableModel tableModel = new DefaultTableModel(categoryReportVector, categoryReportColumnNames);
    jCategoryReportTable.setModel(tableModel);

    //setting the table renderer
    VectorTableCellRenderer renderer = new VectorTableCellRenderer();
    jCategoryReportTable.getColumnModel().getColumn(1).setCellRenderer(renderer);

    //additional modifications
    jCategoryReportTable.setEnabled(false);
    jCategoryReportTable.setRowHeight(100);