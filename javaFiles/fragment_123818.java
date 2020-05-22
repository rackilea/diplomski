MATCH (start:JAVA {snapshot: 3})
CALL apoc.path.subgraphNodes(start, {relationshipFilter:'>'}) YIELD node as n
WITH n
SKIP 1 // so we don't apply this to the start node
SET n.scope = 'JAVA'
RETURN n.ID