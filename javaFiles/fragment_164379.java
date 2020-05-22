private String getAppDataDirectory(String subDirectory, boolean create) {

    String appDataDirectory;
    try {
        appDataDirectory = System.getenv("APPDATA"); //Windows
        //todo - could try "ALLUSERSPROFILE"
        if (appDataDirectory != null) {
            appDataDirectory += File.separator + subDirectory + File.separator;
        }
        else { //appDataDirectory is null
            appDataDirectory = System.getenv("HOME"); //Unix
            if (appDataDirectory != null) {
                appDataDirectory +=  File.separator + subDirectory + File.separator;
            }
            else { //appDataDirectory is still null
                throw new Exception("Could not access APPDATA or HOME environment variables");
            }
        }
    }
    catch(Exception e) {
        e.printStackTrace();
        appDataDirectory = "";
    }

    if (create && appDataDirectory != null && appDataDirectory.length() > 0) {
        try {
            File dir = new File(appDataDirectory);
            dir.mkdir();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    //log("appDataDirectory: " + appDataDirectory);
    return appDataDirectory;
}