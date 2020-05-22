SQL> create table empty_table (
  2    col1 number(10,2),
  3    col2 varchar2(100),
  4    col3 varchar2(100 byte),
  5    col4 varchar2(100 char)
  6  );

Table created.

SQL>   select column_name, data_type, data_length
  2      from all_tab_columns
  3     where table_name = 'EMPTY_TABLE'
  4  order by column_name;

COLUMN_NAME                    DATA_TYPE      DATA_LENGTH
------------------------------ -------------- -----------
COL1                           NUMBER                  22
COL2                           VARCHAR2               100
COL3                           VARCHAR2               100
COL4                           VARCHAR2               300