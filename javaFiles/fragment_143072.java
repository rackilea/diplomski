Query q = pm.newQuery (...);
q.setWhere(...);
q.setRange (...);
q.setOrdering (...);
q.setLimit(...);
q.newParameter(...); // declare a query parameter

q.execute(34.5); // execute the SQL query with a parameter