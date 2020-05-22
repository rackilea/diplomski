CREATE empbase;

// Import data and schema for empbase; the '_EmpBase' is required by SpringData-neo4j
USING PERIODIC COMMIT 500
LOAD CSV WITH HEADERS FROM "file:/tmp/empbase.csv" AS row
CREATE (:EmpBase:_EmpBase {  e_id:      row.e_id,
                    e_bossId:  row.e_bossid,
                    e_name:    row.e_name});

//Create index
CREATE INDEX ON :EmpBase:(e_id);

// Create relationships
LOAD CSV WITH HEADERS FROM "file:/tmp/empbase.csv" AS row
MATCH (employee:EmpBase:_EmpBase    {e_id: row.e_id})
MATCH (manager:EmpBase:_EmpBase     {e_id: row.e_bossid})
MERGE (employee)-[:REPORTS_TO]->(manager);