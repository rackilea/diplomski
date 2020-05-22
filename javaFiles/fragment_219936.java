public class DatabaseBackupReminder extends Thread

/*****************Variables ****************/
String backupFrequency; //How often to backup? Daily, Monthly, Weekly, or Never
String backupTimeOfDay; //I don't use this, but the idea was to autobackup morning,  
                        //day, or night
boolean backupIsSet = false;    //Have they set a schedule?
Timestamp lastBackupRunTime; //Pulled from our Derby database to see when the backup was run
Timestamp backupScheduleSetTime; //Pulled from the DB to see when the user set the schedule
                                //This is so, if they set it to daily, we will check 24hrs from the set date for
                                //backup validity
Period periodSinceLastBackup; //Using the Joda library, we use this to calculate
boolean backupEverRan; //We check to see if they've ever backed up
                                    //Useful logic for clear dialog purposes.
public enum enumBackupFrequencies {DAILY, WEEKLY, MONTHLY, NEVER} //use a valueOf with the backupFrequency.
//We're using java 1.7, no Switch on strings, this is a workaround
   Herd herd;//Herd is a custom datatype we use, it's basically a wrapper around a Derby table.
/*******************methods***************************************/                                     
    public DatabaseBackupReminder(String backupFrequency, String backupTimeOfDay, Timestamp lastBackupRunTime, Timestamp backupScheduleSetTime, Herd herd) 
    //Constructor
    //Herd is a custom datatype we use, it's basically a wrapper around a Derby table.
    boolean getBackupStillValid() //Checks based on lastBackupRunTime, and backupEverRan to see
    //if we have a valid backup

    public void promptForBackup(Period duration, boolean backupEverRunx) 
        //Take's the duration & has it ever run and displays a message.
        //Something like "It's been 2 weeks, 1 days since your last backup"
        //Not fully implemented, this was scrapped, but I'll explain how I think it should have worked below

    public void run()
    //Main thread for this reminder
    public String timeSinceLastBackupString()
    //Calls it based on objects values, not specific values, see method below
    public String timeSinceLastBackupString(Period duration, boolean backupEverRunx)
    //Constructs the string used in promptForBackup



/********full method code**********/
public DatabaseBackupReminder(String backupFrequency, String backupTimeOfDay, Timestamp lastBackupRunTime, Timestamp backupScheduleSetTime, Herd herd) {
    this.herd = herd;
    if (backupFrequency == null) {
        backupFrequency = "";
    }
    if (backupTimeOfDay == null) {
        backupTimeOfDay = "";
    }
    if (backupScheduleSetTime == null) {
        this.backupScheduleSetTime = new Timestamp(0);
    } else {
        this.backupScheduleSetTime = backupScheduleSetTime;
    }
    this.backupFrequency = backupFrequency;
    this.backupTimeOfDay = backupTimeOfDay;
    if (lastBackupRunTime == null) {
        this.lastBackupRunTime = new Timestamp(0);
    } else {
        this.lastBackupRunTime = lastBackupRunTime;
    }
    periodSinceLastBackup = new Period(this.lastBackupRunTime.getTime(), Calendar.getInstance().getTimeInMillis());
    if (backupFrequency.trim().length() > 1) {
        backupIsSet = true;
    }
    backupEverRan = false;
    if (this.lastBackupRunTime.getTime() != 0) {
        backupEverRan = true;
    }
}

 boolean getBackupStillValid() {
    if (lastBackupRunTime.getTime() > 0) {
        backupEverRan = true;

    } else {
        return false;
    }
    if (backupFrequency.trim().length() > 1) {
        backupIsSet = true;

    }


    if (backupIsSet) {
        switch (enumBackupFrequencies.valueOf(backupFrequency.trim().toUpperCase())) {
            case DAILY:
                if (periodSinceLastBackup.getYears() > 1 || periodSinceLastBackup.getMonths() > 1 || periodSinceLastBackup.getWeeks() > 1 || periodSinceLastBackup.getDays() >= 1) {

                    return false;
                }
                break;
            case WEEKLY:
                if (periodSinceLastBackup.getYears() > 1 || periodSinceLastBackup.getMonths() > 1 || periodSinceLastBackup.getWeeks() >= 1) {
                    return false;

                }
                break;
            case MONTHLY:
                if (periodSinceLastBackup.getYears() > 1 || periodSinceLastBackup.getMonths() >= 1) {
                    return false;

                }
                break;
            case NEVER:
        }
    }
    if (backupEverRan) {
        return true;
    } else {
        return false;
    }

}

public void run() {

    if (backupIsSet) {
        switch (enumBackupFrequencies.valueOf(backupFrequency.trim().toUpperCase())) {
            case DAILY:
                if (periodSinceLastBackup.getYears() > 1 || periodSinceLastBackup.getMonths() > 1 || periodSinceLastBackup.getWeeks() > 1 || periodSinceLastBackup.getDays() > 1) {

                    promptForBackup(periodSinceLastBackup, backupEverRan);

                }
                break;
            case WEEKLY:
                if (periodSinceLastBackup.getYears() > 1 || periodSinceLastBackup.getMonths() > 1 || periodSinceLastBackup.getWeeks() > 1) {
                    promptForBackup(periodSinceLastBackup, backupEverRan);

                }
                break;
            case MONTHLY:
                if (periodSinceLastBackup.getYears() > 1 || periodSinceLastBackup.getMonths() > 1) {
                    promptForBackup(periodSinceLastBackup, backupEverRan);

                }
                break;
            case NEVER:
        }
    }



}
public void promptForBackup(Period duration, boolean backupEverRun) {
    int response;
    long delay = 0;

    response = JOptionPane.showConfirmDialog(null, timeSinceLastBackupString(duration, backupEverRun));
    if (response == JOptionPane.NO_OPTION) {
        //TODO: open "how long to remind" dialog
        BackupSnoozePanel snoozePanel = new BackupSnoozePanel();

        JOptionPane.showMessageDialog(null, snoozePanel);

        switch (snoozePanel.BackupDelayInterval.getSelectedIndex()) {
            case 0:
                delay = 5000; //5 seconds, for testing
                //delay = 60 * 60 * 1000; // 1 hour
                break;
            case 1:
                delay = 10000; //10 seconds, for testing
                //delay = 4 * 60 * 60 * 1000; // 4 hours
                break;
            case 2:
                delay = 15000; //15 seconds, for testing
                //delay = 8 * 60 * 60 * 1000; // 8 hours
                break;
            case 3:
                delay = 20000; //20 seconds, for testing
                ///delay = 12 * 60 * 60 * 1000; // 12 hours
                break;
            case 4:
                delay = 0; //next boot
                break;
        }


    } else {
        //TODO: run backup    
    }
    try {

        if (delay > 0) {
        //TODO: Code to sleep this reminder. Thread.sleep(delay) probably

        }
    } catch (Exception ex) {
        //TODO: something to handle exceptions
    }

}//end promptForBackup

 public String timeSinceLastBackupString(Period duration, boolean backupEverRunx) {

    if (!backupEverRunx) {
        return "The backup has never been run. Would you like to run one?";
    }


    String durationString = "It has been ";
    if (duration.getYears() >= 1) {
        durationString += duration.getYears() + " years";
    }
    if (duration.getMonths() >= 1) {
        durationString += duration.getMonths() + " months";
    }
    if (duration.getWeeks() >= 1) {
        durationString += duration.getWeeks() + " weeks ";
    }
    if (duration.getDays() >= 1) {
        durationString += duration.getDays() + " days";
    }
    durationString += " since your last backup. Would you like to run one?";
    return durationString;
}

public String timeSinceLastBackupString() {
    return timeSinceLastBackupString(periodSinceLastBackup, backupEverRan);



}