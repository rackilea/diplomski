merge into RUN_LOG tgt using (
   select job_name, timestamp 
   from my_new_temp_table 
) src 
on (src.job_name = tgt.job_name) 
when matched then update set
   tgt.timestamp = src.timestamp
when not matched then insert values (src.job_name, src.timestamp)
;