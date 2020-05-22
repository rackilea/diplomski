SELECT VARIABLE_NAME, gv.VARIABLE_VALUE 'Global', tv.VARIABLE_VALUE 'Thread value', THREAD_ID, PROCESSLIST_ID 
FROM performance_schema.global_variables gv   
  JOIN performance_schema.variables_by_thread tv USING (VARIABLE_NAME) 
  JOIN performance_schema.threads USING(THREAD_ID) 
WHERE gv.VARIABLE_VALUE <> tv.VARIABLE_VALUE ;

+-----------------------+--------------------+--------------------+-----------+----------------+
| VARIABLE_NAME         | Global             | Thread value       | THREAD_ID | PROCESSLIST_ID |
+-----------------------+--------------------+--------------------+-----------+----------------+
| autocommit            | ON                 | OFF                |        82 |             56 |
| character_set_client  | utf8mb4            | utf8               |        82 |             56 |
| character_set_results | utf8mb4            |                    |        82 |             56 |