MATCH (u:User)
WHERE u.username = { username }
UNWIND { h_items } AS it
MATCH (i:Item)
WHERE i.itemId = it
CREATE (u)-[:HAVE_HOBBY]->(i)
RETURN u, i;