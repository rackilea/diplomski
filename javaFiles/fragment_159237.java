public static final String CONTEXT = "DECLARE in_cnt__date DATE := ? ;" +
"hv_cnt_id NUMBER := 0; " +
"BEGIN DBMS_OUTPUT.ENABLE (NULL); " +
"INSERT INTO dt_contexts (CNT_ID, CNT_CONTEXT, CNT_TYPE, CNT_SOURCE, CNT_COMMENT, CNT_DATE, CNT_DATE_INSERT, CNT_DATE_UPDATE) " +
"VALUES (0, 'EPE_CONTEXT', 'ROUTE', 'bdd', 'Built from ROUTE', in_cnt__date, SYSDATE, SYSDATE); " +
"SELECT SEQ_DT_CNT_ID.CURRVAL INTO hv_cnt_id FROM DUAL; " +
"? := hv_cnt_id;
"EXCEPTION WHEN OTHERS THEN RAISE ; END;";