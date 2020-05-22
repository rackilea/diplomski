StringBuilder sql = new StringBuilder();
sql.Append("SELECT 1 FROM ");
sql.Append(QuoteTableName(tableName));
sql.Append(" WHERE ");
bool firstCol = true;
for(String col: columns) {
   if(firstCol) {
      firstCol = false;
   } else {
      sql.Append(" AND ");
   }    
   sql.Append(QuoteColumnName(col));
   sql.Append(" = ?");    
}