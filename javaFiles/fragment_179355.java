@Override
@Transactional
public void run() {
    insertSeveralRecords();
}

private void insertSeveralRecords(){
    try {
        Thread.sleep(500);
        insertRecord(1);
        Thread.sleep(1000);
        insertRecord(2);
    } catch (InterruptedException e) {
        log.error("Inserts were interrupted", e);
    }
}