CREATE (f:Foo { bar: 1 });

MATCH (f:Foo) 
REMOVE f:Foo   /* Remove label */
REMOVE f.bar   /* Remove property */
RETURN f;      /* Return empty node */