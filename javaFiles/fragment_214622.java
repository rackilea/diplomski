Dialect dialect= Dialect.getDialect();
       //<-- compare against the expected dailect classes
       if(dialect instanceof OracleDialect){  
           //your database is oracle
       }else if(dialect instanceof HSQLDialect){
        //<-- compare against the expected dailect classes
           //your database is HSQL
       }