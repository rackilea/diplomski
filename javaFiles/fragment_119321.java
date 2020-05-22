Runtime.getRuntime().addShutdownHook(new Thread() {
    @Override
    public void run() {
        Launcher.logService.log(LogService.LOG_WARNING, "HANDLE SHUTDOWN");
        if(Launcher.framework != null) {
            try {
                Launcher.framework.stop();
                Launcher.framework.waitForStop(0); // !!!
            } catch (BundleException e) {
                Launcher.logService.log(LogService.LOG_ERROR, "Shutdown" + ((Launcher.framework != null) ? " of " + Launcher.framework.getSymbolicName() + " " : " ") + "failed!", e);
                System.exit(-1);
            }
        }
    }
});