DECLARE
L_jobno INTEGER;
BEGIN
Dbms_job.submit (
L_jobno,
'BEGIN your_procedure( argument_list ); END;',
Sysdate + interval '1' minute );
Commit;
END;