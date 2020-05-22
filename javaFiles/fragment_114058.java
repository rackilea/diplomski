// Center alignment for "selected" column
        ColumnAlignmentRenderer cellRenderer = new ColumnAlignmentRenderer(getTable().getDefaultRenderer(Object.class));
        cellRenderer.setSpecialColumnAlignment(MyTableModel.COL_TO_CENTER, SwingConstants.CENTER);
        getTable().setDefaultRenderer(Object.class, cellRenderer);

        // Center alignmet for "selected" column header
        ColumnAlignmentRenderer headerRenderer = new ColumnAlignmentRenderer(getTable().getTableHeader().getDefaultRenderer());
        headerRenderer.setSpecialColumnAlignment(MyTableModel.COL_TO_CENTER, SwingConstants.CENTER);
        getTable().getTableHeader().setDefaultRenderer(headerRenderer);