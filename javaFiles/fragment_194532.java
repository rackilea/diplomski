CREATE CONSTRAINT ON (p:Person) ASSERT p.userid IS UNIQUE
CREATE CONSTRAINT ON (p:Person) ASSERT p.username IS UNIQUE

CREATE (p:Person { userid:8423,username:"jomski2009" }) RETURN p
-> {userid:8423, username:"jomski2009"}

MATCH (p:Person { userid:8423 }) RETURN p
-> {userid:8423, username:"jomski2009"}

MATCH (p:Person { username:"jomski2009" }) RETURN p
-> {userid:8423, username:"jomski2009"}