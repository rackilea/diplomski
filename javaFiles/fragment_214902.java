-- prevent new connections between the moment you killed everything 
-- and the moment where the database is dropped    
alter database your_db_name allow_connections false;

select pg_terminate_backend(pid)
from pg_stat_activity
where datname = 'your_db_name'
  and pid <> pg_backend_pid();

drop database your_db_name;