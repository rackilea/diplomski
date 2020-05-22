stmt.executeUpdate("CREATE TABLE "+tableName+" " +
               "(id INTEGER not NULL, " +
               " username VARCHAR(255), " + 
               " pass VARCHAR(255), " + 
               " age INTEGER, " + 
               " PRIMARY KEY ( id ))");