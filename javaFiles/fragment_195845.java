SELECT * FROM lock_table;

if locks.length > 0: someone else is running

LOCK lock_table;
INSERT INTO lock_table VALUES(my_pid);
UNLOCK lock_table;

SELECT pid FROM lock_table;

if pids.length > 1: what happened?
if pids[0] != my_pid: someone else got the lock