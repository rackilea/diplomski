private boolean isBatteryCharging(){
        int battst = DeviceInfo.getBatteryStatus();
        if(((battst & DeviceInfo.BSTAT_IS_USING_EXTERNAL_POWER) != 0) 
            || ((battst & DeviceInfo.BSTAT_CHARGING) != 0) 
            || ((battst & DeviceInfo.BSTAT_AC_CONTACTS) != 0)){
            return true;
        }
        return false;       
    }