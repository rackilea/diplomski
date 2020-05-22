> insert into test (id, val) VALUES (uuid(), 'some value') using ttl 100;
> select val, TTL(val) from test;

 val           | ttl(val)
---------------+--------------
   hello world |      92