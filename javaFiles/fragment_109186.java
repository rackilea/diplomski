while (result.next()) {
        Vector row = new Vector(columnCount);
        for (int j = 1; j <= columnCount; j++) {
            row.add(result.getString(j));

        }
        data.addElement(row);
    }