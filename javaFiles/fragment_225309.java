DO $$
DECLARE table_name text:= 'demo';
DECLARE column_name text:= 'column_';
BEGIN
    EXECUTE 'CREATE TEMP TABLE ' || quote_ident(table_name || '_test')||' (' ||quote_ident(column_name||'a')|| ' integer,' ||quote_ident(column_name||'b')|| ' integer)';
END $$;
SELECT * FROM demo_test;