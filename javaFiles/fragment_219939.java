class BackupRunner implements Runnable {

Herd herd;
LoadStatusDialog lsd; 

BackupRunner(Herd herd, LoadStatusDialog lsd) {
    this.herd = herd;
    this.lsd = lsd;
}

@Override
public void run() {



    DbBackupAction dba = new DbBackupAction();
    Thread dbaThread = new Thread(dba);

    dbaThread.start();
    while (dbaThread.isAlive()) {
        try {
            dbaThread.join();
        } catch (InterruptedException ex) {
            Exceptions.printStackTrace(ex);
        }
    }


    if (dba.isBackupSuccess()) {

        RemoteBackupAction rba = new RemoteBackupAction();
        lsd.setProgressBarIndeterminate(true);
        Thread rbaThread = new Thread(rba);
        rbaThread.start();
        while (rbaThread.isAlive()) {
            try {
                rbaThread.join();
            } catch (InterruptedException ex) {
                Exceptions.printStackTrace(ex);
            }
        }



        if (rba.isBackupSuccess()) {


            herd.setBackupScheduledLastRun(new Timestamp(Calendar.getInstance().getTimeInMillis()));
            HerdService hs = new HerdDaoService();
            hs.update(herd);

            EventBus.publish(new RefreshStartScreenEvent());
        }
    }
}
}