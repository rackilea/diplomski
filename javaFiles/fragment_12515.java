SELECT directory_path INTO v_path
  FROM all_directories
 WHERE directory_name = '<oracle_dir_name>';

dbms_java.grant_permission( 'SCOTT', 
 'SYS:java.io.FilePermission', 
 v_path, 
 'read');