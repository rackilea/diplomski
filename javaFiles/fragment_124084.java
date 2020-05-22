import java.io.File;

import org.netbeans.Main;

/**
 * Launches Netbeans Rich Client Platform application where mulitple instances of 
 * the application can run simultaneously for the same user.
 * <p>
 * Netbeans does not allow to run several instances of an application for the same 
 * user simultaneously, but this class does the job by fooling Netbeans.
 * If an instance is already running then a new folder is created and used for this instance.
 * </p>
 * <p>
 * This is quite tricky and this class is indeed a hack to override Netbeans behaviour.
 * An example makes it a little easier to understand, when application is first started 
 * Netbeans userdir is set from a configuration file like {@code etc/xxxxx.conf} to something like:<br>
 * {@code /home/username/.xxxxx/dev/} which includes a lock file.
 * <br>
 * If application is started again then this lock file is checked and Netbeans tries to connect to the other instance through a socket.
 * This class does the trick by never using this folder but instead creating unique directories for each instance like:<br>
 * {@code /home/username/.xxxxx/instance_01/netbeans/}<br>
 * {@code /home/username/.xxxxx/instance_02/netbeans/}<br>
 * {@code /home/username/.xxxxx/instance_03/netbeans/}<br>
 * ...
 * </p>
 * 
 */
public class MultipleInstancesMain
{
    /** Key for Netbeans default user dir */
    private static final String NETBEANS_USER = "netbeans.user";

    /** Argument to Netbeans for alternate user dir */
    private static final String USERDIR_ARG = "--userdir";

    /** Like "C:\Documents and Settings\username\Application Data\.xxxxx" or "/home/username/.xxxxx" */
    private static final File MAIN_DIR = getMainDir();

    /** Sub dir of MAIN_DIR for each instance of application */
    private static final String INSTANCE_DIR = "instance";

    /** Sub dir of INSTANCE_DIR where netbeans stores it's settings, logs and cache */
    private static final String NETBEANS_SUBDIR = "netbeans";

    /** Name of Netbeans lock file inside of NETBEANS_SUBDIR */
    private static final String LOCKFILE = "lock";

    /** Max number of instance directories we allow */
    private static final int MAX_DIR_COUNT = 999;

    /** Padding of instance dir */
    private static final String PAD = "000";
    private static final int PAD_LENGTH = PAD.length();

    /** 
     * Lock file could be present even though application is not running (after crash).
     * So we treat it as "dead" after some time, to prevent "dead directories".
     */
    private static final long LOCKFILE_MAX_AGE_IN_MILLIS = 1000L * 60L * 60L * 24L * 30L; // 30 days

    /**
     * Launches application with multiple instances support.
     * @param args command line arguments
     */
    public static void main(String[] args) throws Exception
    {
        // Get directory for this instance
        String[] userDir = new String[2];
        userDir[0] = USERDIR_ARG;
        userDir[1] = getNetbeansDir();

        // Remove default dir and set this class not to run again
        deleteDefaultNetbeansDir();
        System.clearProperty("netbeans.mainclass");

        // Start Netbeans again with new userdir and default main class
        startNetbeans(args, userDir);
    }

    /**
     * Starts Netbeans.
     * @param oldArgs command line arguments
     * @param newArgs new arguments added
     */
    private static void startNetbeans(String[] oldArgs, String[] newArgs)  throws Exception
    {
        String[] args = new String[oldArgs.length + newArgs.length];

        for (int i = 0; i <oldArgs.length; i++)
        {
            args[i] = oldArgs[i];
        }

        for (int i = 0; i < newArgs.length; i++)
        {
            args[oldArgs.length + i] = newArgs[i];
        }

        Main.main(args);
    }

    /**
     * @return the directory that Netbeans will use for this instance of the application 
     */
    private static String getNetbeansDir()
    {
        for(int i = 1; i <= MAX_DIR_COUNT; i++)
        {
            File instanceDir = getSuffixedInstanceDir(i);
            if (isLockFileFree(instanceDir))
            {
                File dirToUse = new File(instanceDir, NETBEANS_SUBDIR);
                return dirToUse.getAbsolutePath();
            }
        }

        // This would probably never happen, but we don't want an eternal loop above
        String errorMessage = String.format("Unable to find Netbeans userdir, %s dirs checked in '%s'", 
                MAX_DIR_COUNT, MAIN_DIR.getAbsolutePath());
        throw new RuntimeException(errorMessage);
    }

    private static File getSuffixedInstanceDir(int count)
    {
        String suffix = PAD + count;
        suffix = suffix.substring(suffix.length() - PAD_LENGTH);
        File suffixedDir = new File(MAIN_DIR, INSTANCE_DIR + "_" + suffix);
        return suffixedDir;
    }

    /**
     * Checks is if Netbeans lock file is free.
     * @param instanceDir directory to look for Netbeans directory and lock file in 
     * @return true if {@code instanceDir} does not have a Netbeans folder with a occupied lock file
     */
    private static boolean isLockFileFree(File instanceDir)
    {
        File netbeansDir = new File(instanceDir, NETBEANS_SUBDIR);
        File lockFile = new File(netbeansDir, LOCKFILE);

        if (lockFile.exists())
        {
            return deleteLockFileIfOldEnough(lockFile);
        }
        else
        {
            return true;
        }
    }

    /**
     * Deletes the lock file if it's old enough.
     * @param lockFile lock file to delete
     * @return true if it was deleted
     * @see #LOCKFILE_MAX_AGE_IN_MILLIS
     */
    private static boolean deleteLockFileIfOldEnough(File lockFile)
    {
        long currentTime = System.currentTimeMillis();
        long fileCreated = lockFile.lastModified();
        long ageInMillis = currentTime - fileCreated;

        if (ageInMillis > LOCKFILE_MAX_AGE_IN_MILLIS)
        {
            return lockFile.delete();
        }
        else
        {
            return false;
        }
    }

    /**
     * Netbeans is started with a default userdir, but we need to have a unique dir for each instance.
     * Main dir is the directory where directories of all instances are.
     * @return main directory in users home area where application settings, logs and cache is stored
     */
    private static File getMainDir()
    {
        String defaultNetbeansDir = System.getProperty(NETBEANS_USER);
        File mainDir = new File(defaultNetbeansDir).getParentFile();
        return mainDir;
    }

    /**
     * Since we don't use default Netbeans dir at all, we remove it completely.
     */
    private static void deleteDefaultNetbeansDir()
    {
        File defaultNetbeansDir = new File(System.getProperty(NETBEANS_USER));
        Thread t = new Thread(new DirectoryDeleter(defaultNetbeansDir), "NetbeansDirDeleter");
        t.start();
    }

    /**
     * There are unpredictable behaviour when deleting Netbeans default directory, sometime it succeeds and sometimes not.
     * But after some attempts it always succeeds, by deleting it in the background it will eventually be deleted.
     * @author username
     */
    private static class DirectoryDeleter implements Runnable
    {
        private static final long SLEEP_TIME = 3000;
        private final File dirToDelete;

        DirectoryDeleter(File dirToDelete)
        {
            this.dirToDelete = dirToDelete;
        }

        /**
         * @see java.lang.Runnable#run()
         */
        public void run()
        {
            while(!deleteDirOrFile(dirToDelete))
            {
                try
                {
                    Thread.sleep(SLEEP_TIME);
                }
                catch (InterruptedException e)
                {
                    // No idea to do anything here, should never happen anyway...
                    continue;
                }
            }
        }

        /**
         * Deletes a file or directory
         * @param dirFile directory or file to delete
         * @return true if deletion succeeded
         */
        private boolean deleteDirOrFile(File dirFile)
        {
            if (dirFile.isDirectory())
            {
                for (File f : dirFile.listFiles())
                {
                    boolean deleted = deleteDirOrFile(f);
                    if (!deleted)
                    {
                        return false;
                    }
                }
            }

            // The directory is now empty so delete it
            return dirFile.delete();
        }
    }
}