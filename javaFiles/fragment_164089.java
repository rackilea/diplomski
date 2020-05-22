sqlite> CREATE TABLE test (
    a INTEGER FABBELBABBEL NOT NULL
);
sqlite> .schema test
CREATE TABLE test (a INTEGER FABBELBABBEL NOT NULL);
sqlite> INSERT INTO test (a) VALUES (1);
sqlite> INSERT INTO test (a) VALUES (NULL);
Error: NOT NULL constraint failed: test.a