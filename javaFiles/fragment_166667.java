while(resultSet.next()) {
    date = resultSet.getString("iddata");
    company = resultSet.getString("idazienda");
    order = resultSet.getString("idcommessa");

    // add your check here
    if((sData.equals(date) && sAzienda.equals(company)) && sCommessa.equals(order)) {
        out.print("already sent");
        break;
    } 
}