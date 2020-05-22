CREATE INDEX ON :Office(rc);

CREATE INDEX ON :Person(numDoc);

// make sure the indexes are online

:schema await

MATCH (x:Office{ rc:"345421"})
LOAD CSV FROM  "file:///path/to/file" AS csvLine
MERGE (n:Person { numDoc: toInt(csvLine[1]) })
CREATE (n) -[:Afil]-> (x);