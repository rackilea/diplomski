public void checkInstalled(){
    try {
        String regValue = null;
            regValue = WinRegistry.valueForKey(WinRegistry.HKEY_LOCAL_MACHINE, setWin, "InstallDir");
        if(regValue == null){
            System.err.println("Application not installed!");
        } else {
            "do the other thing"
            }
        } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException | IOException ex) {
        System.err.println(ex);
        }
    }