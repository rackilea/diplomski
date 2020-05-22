CREATE TEMP TABLE tab (ID int, "A column" text);
INSERT INTO tab VALUES 
  (1, '{"A1":["1"]}'),
  (2, '{"A2":["2"], "B":["3"]}'),
  (3, '{"A2":["1","2"], "B":["3"]}');

SELECT * FROM tab WHERE ("A column"::json->>'A2') = '["1","2"]';