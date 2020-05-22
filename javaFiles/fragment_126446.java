String sql_statement = "";
for(HashSet<String> names : BMap.values()){
  for(String name : names){
    sql_statement += "'" + name + "',";
  }
}
sql_statement = sql_statement.substring(0, sql_statement.length-1); // to remove the comma at the end