Parameters:
sql - an SQL Data Manipulation Language (DML) statement, such as INSERT, 
      UPDATE or DELETE; or an SQL statement that returns nothing, 
      such as a DDL statement.
Returns:
      either (1) the row count for SQL Data Manipulation Language (DML) 
      statements or (2) 0 for SQL statements that return nothing
Throws:
      SQLException - if a database access error occurs, this method is called on
      a closed Statement or the given SQL statement produces a ResultSet object