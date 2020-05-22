declare
direct varchar2(100);
qry varchar2(200);
begin
direct := '/home/oracle/Desktop/sql/images';
qry := q'[CREATE OR REPLACE DIRECTORY IMG_DIR_TMP AS ']'||direct||q'[;']';
DBMS_OUTPUT.PUT_LINE(qry);
execute immediate qry;
end;