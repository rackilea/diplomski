String expr = "SELECT * FROM [text:column] WHERE [text:data] LIKE 'somestring'";
Query query = session.getWorkspace().getQueryManager().createQuery(expr, Query.JCR_SQL2);    
QueryResult result = query.execute(); 
RowIterator iter = result.getRows();
while (iter.hasNext()) {
     //your code
}