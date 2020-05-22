CREATE TEMPORARY VIEW words
  USING org.apache.spark.sql.cassandra
  OPTIONS (
    table "words",
    keyspace "test"
  );

SELECT * FROM words;
// Hello    1
// World    2