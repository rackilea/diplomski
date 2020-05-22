MATCH (e:event {id:{id}}),(r:resource)
WHERE r.md5 IN {used}
FOREACH(
  idx in RANGE(0,SIZE({fileMD5})-1) |
  FOREACH( 
    filePath IN CASE WHEN r.md5 = {fileMD5}[idx] THEN [{fileInfo}[idx]] ELSE [] END |
    CREATE UNIQUE (r)-[:USED_BY {filePath:filePath }]->(e)
  )
)