private String makeInsertQuery(List<String> listOfColumnsNames, List<Object> listOfParameters, String tableName){
    StringBuilder columns = new StringBuilder();
    StringBuilder parameters = new StringBuilder();
    String query = null;

    if(listOfColumnsNames != null && listOfColumnsNames.size() != 0 && listOfParameters != null && listOfParameters.size() != 0 && tableName != null){
        for(String string : listOfColumnsNames){
            columns.append(string + ",");
        }
        columns.deleteCharAt(columns.length() - 1);

        for(Object object : listOfParameters){
            parameters.append ("'" + object + "'" + ",");
        }
        parameters.deleteCharAt(parameters.length() - 1);

        query = "INSERT " + "INTO " + tableName +  " ( " + columns.toString() + " ) " + " VALUES " + "( " + parameters.toString() + " )" ; 
    }
    //TODO if you need check for null 
    return query;
}