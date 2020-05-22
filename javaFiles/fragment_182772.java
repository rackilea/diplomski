private final Collection<Integer> matchingRows = new HashSet<>();

// ...

    table.setDefaultRenderer(Object.class, new ColorChange(matchingRows));

    table.getModel().addTableModelListener(event -> {
        int type = event.getType();
        int column = event.getColumn();
        TableModel model = (TableModel) event.getSource();
        int firstRow = event.getFirstRow();
        int lastRow = event.getLastRow();

        if (firstRow == TableModelEvent.HEADER_ROW) {
            table.repaint();
            return;
        }

        if (type == TableModelEvent.UPDATE) {
            if ((column == 4 || column == 5) && firstRow == lastRow) {
                int editedRow = firstRow;
                Object edMainC = model.getValueAt(editedRow, 4);
                Object edSubC = model.getValueAt(editedRow, 5);

                matchingRows.clear();
                int count = model.getRowCount();
                for (int row = 0; row < count; row++) {
                    if (row != editedRow) {
                        Object mainC = model.getValueAt(row, 4);
                        Object subC = model.getValueAt(row, 5);
                        if (Objects.equals(mainC, edMainC) ||
                            Objects.equals(subC, edSubC)) {

                            matchingRows.add(row);
                        }
                    }
                }
            }
        } else if (type == TableModelEvent.INSERT) {
            int start = Math.min(firstRow, lastRow);
            int count = Math.abs(lastRow - firstRow) + 1;

            List<Integer> newRows = new ArrayList<>(matchingRows);
            newRows.replaceAll(row -> row < start ? row : row + count);

            matchingRows.clear();
            matchingRows.addAll(newRows);
        } else if (type == TableModelEvent.DELETE) {
            int start = Math.min(firstRow, lastRow);
            int end = Math.max(firstRow, lastRow);
            int count = end - start + 1;

            List<Integer> newRows = new ArrayList<>(matchingRows);
            newRows.removeIf(row -> row >= start && row <= end);
            newRows.replaceAll(row -> row <= end ? row : row - count);

            matchingRows.clear();
            matchingRows.addAll(newRows);
        }

        table.repaint();
    });