RangeSlicesQuery<String, String, String> rangeSlicesQuery =
            HFactory.createRangeSlicesQuery(keyspace, ss, ss, ss)
                    .setColumnFamily("User")
                    .setRange(null, null, false, rowCount)
                    .setRowCount(rowCount)
                    .setReturnKeysOnly();

    String lastKey = null;

    while (true) {
        rangeSlicesQuery.setKeys(lastKey, null);

        QueryResult<OrderedRows<String, String, String>> result = rangeSlicesQuery.execute();
        OrderedRows<String, String, String> rows = result.get();
        Iterator<Row<String, String, String>> rowsIterator = rows.iterator();

        /**
         * we'll skip this first one, since it is the same as the last one from previous time we executed.
         */
        if (lastKey != null && rowsIterator != null) {
            rowsIterator.next();
        }
        while (rowsIterator.hasNext()) {
            Row<String, String, String> row = rowsIterator.next();
            lastKey = row.getKey();

            System.out.println(lastkey);
        }

        if (rows.getCount() < rowCount) {
            break;
        }
    }