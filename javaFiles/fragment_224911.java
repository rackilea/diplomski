private String createDescriptionFromResult(ResultSet resultSet, int columnCount) throws SQLException {

        if (columnCount > 2) {
            StringBuilder data_list = new StringBuilder();

            for (int ii = 2; ii <= columnCount; ii++) {
                data_list.append(resultSet.getString(ii));
                if (ii != columnCount)
                    data_list.append(";");
            }
            // data_list has all data from all index you are looking for ..
            return data_list.toString();
        } else {
            // use standard way
            return resultSet.getString(2);
        }
    }