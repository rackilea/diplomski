class DbBackupAction implements Runnable {

private boolean backupSuccess;

public DbBackupAction() {
    this.backupSuccess = false;
}

public void runBackup() {
}

@Override
public void run() {
    Connection connection = JDBCUtils.getConnection();
    String dbName = NbPreferences.forModule(DatabasePanel.class).get("dbName", "");
    try {
        DerbyUtils.backUpDatabase(connection, dbName);
    } catch (SQLException ex) {
        Exceptions.printStackTrace(ex);
    }
    setBackupSuccess(true);
}

/**
 * @return the backupSuccess
 */
public boolean isBackupSuccess() {
    return backupSuccess;
}

/**
 * @param backupSuccess the backupSuccess to set
 */
public void setBackupSuccess(boolean backupSuccess) {
    this.backupSuccess = backupSuccess;
}
}