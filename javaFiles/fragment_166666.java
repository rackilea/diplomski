while(resultSet.next()) {
    // these lines overwrite the local vars for each row
    date = resultSet.getString("iddata");
    company = resultSet.getString("idazienda");
    order = resultSet.getString("idcommessa");
}