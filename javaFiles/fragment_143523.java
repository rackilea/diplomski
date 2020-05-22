//change  insertQueries  as with value as (? ,?)
insertQueries += " VALUES "+ myvalue+"" ;


//get value1 as  ("abc", "xyz") 

//update query as
int row = jdbcTemplate.update(insertQueries, value1);