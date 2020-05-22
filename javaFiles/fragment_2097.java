public void saveSetting(String nameOfSetting, String settingValue) {
    try {
        InputStream inputStream = new FileInputStream(this.settingsFileName);
        Properties programProperties = new Properties();
        programProperties.load(inputStream);
        inputStream.close();
        OutputStream outputStream = new FileOutputStream(this.settingsFileName);
        programProperties.setProperty(nameOfSetting, settingValue);
        programProperties.store(outputStream, null);
        outputStream.close();
    }
    catch (Exception errorException) {
        Common.errorEncountered(errorException, "An error occured while trying to load a setting from the file " + this.settingsFileName + ".");
    }
}