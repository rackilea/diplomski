DECLARE
  v_table_name VARCHAR2(30) := 'dual';
  v_search_string VARCHAR2(100) := 'X';
  v_sql VARCHAR2(4000);
  c_result SYS_REFCURSOR;
BEGIN
  v_sql := 'SELECT * FROM ' || v_table_name || ' WHERE 1=1';
  FOR r_c IN (SELECT column_name
              FROM all_tab_columns
              WHERE table_name = v_table_name) LOOP
    v_sql := v_sql || ' OR ' || r_c.column_name || ' LIKE ''%' || v_search_string || '%''';
  END LOOP;
  OPEN c_result FOR v_sql;
END;
/