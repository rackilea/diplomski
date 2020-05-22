private void setUpEmulator() {
    try {
        // overrideJ2MeImagePackageLock();
        Headless app = new Headless();
        DeviceEntry defaultDevice = new DeviceEntry("Default device", null, DeviceImpl.DEFAULT_LOCATION, true, false);
        Field field = app.getClass().getDeclaredField("emulator");
        field.setAccessible(true);
        Common emulator = (Common) field.get(app);
        emulator.initParams(new ArrayList<String>(), defaultDevice, J2SEDevice.class);
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Un-handled Exception");
    }
}