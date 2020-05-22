MERGE (employer:Employer {name: $employerName})
WITH employer
UNWIND $names AS name
MERGE (employee:Employee {name: name})
MERGE (employer)-[:Employs]->(employee)
RETURN *