public class DatabaseBackupController
/***********variables*************/
String scheduleText; //Daily, Weekly, Monthy, or Never. It's set in our options panel.
String timeText; //Time of day to run the backup, morning, day, or night. As 04:00-12:00 etc…
Timestamp lastBackupRun; //Timestamp from DB (Herd is our abstracted class) from when it was last run.
Timestamp lastBackupRunScheduleSetTime; //Timestamp from DB when the backup was set.
Herd herd; //Herd is a custom datatype we use, it's basically a wrapper around a Derby table.

/***********Method Headers**********/
public DatabaseBackupController(Herd herd) //Constructor
//Sets global variables, based on values in DB
public void setupBackupReminder() 
//calls DatabaseBackupReminder, passes global variables.
public boolean checkBackupReminder()
//Checks to make sure the current backup is valid within the duration since last backup
public void runBackupPrompt() 
//When we are in fact going to backup, calls BackupRunner instance.


/**********full method code****************/
    public DatabaseBackupController(Herd herd) {
    this.herd = herd;
    scheduleText = herd.getBackupSchedule();
    timeText = herd.getBackupTime();
    lastBackupRun = herd.getBackupScheduledLastRun();
    lastBackupRunScheduleSetTime = herd.getBackupScheduledDatetime();
}

public void setupBackupReminder() {
    DatabaseBackupReminder dbReminder = new DatabaseBackupReminder(scheduleText, timeText, lastBackupRun, lastBackupRunScheduleSetTime, herd);
    Thread dbBackupThread = new Thread(dbReminder);

    dbBackupThread.start();
}//end setupBackupReminder

public boolean checkBackupReminder() {
    DatabaseBackupReminder dbReminder = new DatabaseBackupReminder(scheduleText, timeText, lastBackupRun, lastBackupRunScheduleSetTime, herd);
    return dbReminder.getBackupStillValid();
}

public void runBackupPrompt() {
    DatabaseBackupReminder dbReminder = new DatabaseBackupReminder(scheduleText, timeText, lastBackupRun, lastBackupRunScheduleSetTime, herd);
    int response = JOptionPane.showConfirmDialog(null, dbReminder.timeSinceLastBackupString());
    if (response == JOptionPane.YES_OPTION) {
        //NbPreferences.forModule(BackupSettingsPanel.class).putLong("databaseschedullastrun", Calendar.getInstance().getTimeInMillis());
        LoadStatusDialog lsd;
        lsd = null;
        lsd = new LoadStatusDialog(WindowManager.getDefault().getMainWindow(), false, true);
        lsd.setVisible(true);
        Thread br = new Thread(new BackupRunner(herd,lsd));
        br.start();
    }
}
}//end class