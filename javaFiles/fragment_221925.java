Thread 1: lastUpd = now() 
Thread 1: UPDATE MYTABLE SET LAST_UPDATE=${lastUpd} WHERE ID=${id}
Thread 2: lastUpd = now()
Thread 2: UPDATE MYTABLE SET LAST_UPDATE=${lastUpd} WHERE ID=${id} //remain locked
Thread 1: a lot of work ...
Thread 1 COMMIT
Thread 2: a lot of work ...
Thread 2: lastUpd2= SELECT LAST_UPDATE MYTABLE WHERE ID=${id}
Thread 2: IF lastUpd2!= lastUpd ROLLBACK