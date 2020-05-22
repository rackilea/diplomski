class RemoteBackupAction implements Runnable {

Thread thread;
LoadStatusDialog lsd;
File backupFile;
Pref pref;
private boolean backupSuccess;

public RemoteBackupAction() {
    backupSuccess = false;
}

public void runThread() {

                backupSuccess = true;

                try {
                    DerbyUtils.remoteBackupDatabase(backupFile);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,
                            "This option is not available when working offline.");
                    System.out.println("SQLExcption: " + ex);
                    backupSuccess = false;
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,
                            "Unable to connection to ftp site for remote backup.");
                    System.out.println("IOExcption: " + ex);
                    backupSuccess = false;
                }



}

public void startOffsiteBackup() {
    pref = CentralLookup.getDefault().lookup(Pref.class);
    System.out.println("pref.isOnline(): " + pref.isOnline());
    if (!pref.isOnline()) {
        JOptionPane.showMessageDialog(null,
                "This option is not available when working offline.");
        return;
    }

    File[] files = DerbyUtils.getListOfBackups();
    if ((files == null) || (files.length < 1)) {
        JOptionPane.showMessageDialog(null,
                "There are no backup files available for upload. "
                + "Please create a local backup.");
        return;
    }
    Backup[] backups = new Backup[files.length];
    if (files.length > 0) {
        Date[] dates = new Date[files.length];
        String[] herdCodes = new String[files.length];
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
        for (int i = 0; i < files.length; i++) {
            try {
                String[] splitFileName = files[i].getName().split("_");
                herdCodes[i] = splitFileName[0];
                dates[i] = inFormat.parse(splitFileName[1].split("//.")[0]);
                backups[i] = new Backup(herdCodes[i], files[i], files[i].getName(), dates[i]);
            } catch (ParseException ex) {
                Exceptions.printStackTrace(ex);
            }
        }
    } else {
        System.out.println("no backup files yet");
    }

    Arrays.sort(backups, Collections.reverseOrder());

    if (backups[0] != null) {

        this.backupFile = backups[0].getFile();
    } else {
        // Cancel button selected
        return;
    }

    runThread();
}

/**
 * @return the backupSuccess
 */
public boolean isBackupSuccess() {
    return backupSuccess;
}

@Override
public void run() {
    startOffsiteBackup();
}