int rowCount = 0;
while (resultSet.next()) {
    // you get a single result row in here, not the entire ResultSet
    for (int i = 1; i <= columnCount; i++) {
        ...........................
        switch (type) {
            ..................
        }

    }
    rowCount++;
}