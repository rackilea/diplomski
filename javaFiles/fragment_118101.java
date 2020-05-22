create table my_table
(
   id integer primary key, 
   data clob, 
   constraint validate_json CHECK (data IS JSON)
);