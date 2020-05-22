select owner_name,job_name,state from dba_datapump_jobs;


select b.username, 
       a.sid, 
       b.opname, 
       b.target,
       round(b.SOFAR*100/b.TOTALWORK,0) || '%' as "%DONE", 
       b.TIME_REMAINING,
       to_char(b.start_time,'YYYY/MM/DD HH24:MI:SS') start_time
 from 
       v$session_longops b, 
       v$session a
where 
       a.sid = b.sid      
order by 6;