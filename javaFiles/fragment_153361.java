String[] command = new String[]{"mysql", Constants.DB_NAME, "-u" + Constants.DB_USER, "-p" + Constants.DB_PASSWORD, "-e", " source "+FileName };

    try {
            Process runtimeProcess = Runtime.getRuntime().exec(command);
            int processComplete = runtimeProcess.waitFor();
            if (processComplete == 0)
            {
                System.out.println("DatabaseManager.restore: Restore Successfull");

            }
            else 
            {
                System.out.println("DatabaseManager.restore: Restore Failure!");
            }

        return true;

    }

    catch (final Exception ex) 
    {
        Application.showErrorInConsole(ex);
        NmsLogger.writeErrorLog("Database Restore failed ", ex.toString());
        NmsLogger.writeDebugLog(ex);
        return false;

    }