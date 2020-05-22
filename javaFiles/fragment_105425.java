regress=# CREATE TABLE jsontext(x json);
CREATE TABLE
regress=# PREPARE test(text) AS INSERT INTO jsontext(x) VALUES ($1);
PREPARE
regress=# EXECUTE test('{}')
INSERT 0 1