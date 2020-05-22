if (resultSet.next()) {
    if (id >= startValidRange && id <= endValidRange) {
        foundData = true;
        for (String column : columnsList.split(",")) {
            colData.add(resultSet.getString(column.trim()));
        }
    }
    else
        addException("Data Present for Non Valid ID's", Read.flagTerminate);
}