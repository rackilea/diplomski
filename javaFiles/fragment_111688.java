public boolean isRunningInAppServer() {

        if ("true".equals(System.getProperty("RunningAppServer"))) {
            return true;
        }
        return false;
}