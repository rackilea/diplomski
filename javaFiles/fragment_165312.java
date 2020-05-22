~ $ curl http://localhost:8080/employee
[]
~ $ 
~ $ curl -d '{"name":"Jake"}' -H "Content-Type: application/json" -X POST  http://localhost:8080/employee
{"id":1,"name":"Jake"}
~ $ 
~ $ curl -d '{"name":"Zack"}' -H "Content-Type: application/json" -X POST  http://localhost:8080/employee
{"id":2,"name":"Zack"}
~ $ 
~ $ curl http://localhost:8080/employee
[{"id":1,"name":"Jake"},{"id":2,"name":"Zack"}]