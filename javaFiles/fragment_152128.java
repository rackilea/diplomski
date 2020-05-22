jTextField1.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateFilter(jTextField1.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateFilter(jTextField1.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {//ignore this
            }
        });
    }

    protected void updateFilter(String text) {
        TableRowSorter<TableModel> sorter = (TableRowSorter<TableModel>) jTable1.getRowSorter();
        RowFilter<TableModel, Object> firstFiler = null;
        RowFilter<TableModel, Object> secondFilter = null;
        RowFilter<TableModel, Object> thirdFiler = null;
        RowFilter<TableModel, Object> forthFilter = null;
        List<RowFilter<TableModel, Object>> filters = new ArrayList<RowFilter<TableModel, Object>>();
        RowFilter<TableModel, Object> compoundRowFilter = null;
        try {
            firstFiler = RowFilter.regexFilter(text, 1);
            secondFilter = RowFilter.regexFilter(text, 2);
            thirdFiler = RowFilter.regexFilter(text, 3);
            forthFilter = RowFilter.regexFilter(text, 4);

            filters.add(firstFiler);
            filters.add(secondFilter);
            filters.add(thirdFiler);
            filters.add(forthFilter);

            compoundRowFilter = RowFilter.orFilter(filters);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(compoundRowFilter);
    }