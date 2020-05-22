ArrayList<String> permissions = new ArrayList<>();
    permissions.add(Manifest.permission.ACCESS_FINE_LOCATION);
    //add here your other permissions

    for (int i = 0; i < permissions.size(); i++) {
        String command = String.format("pm grant %s %s", getTargetContext().getPackageName(), permissions.get(i));
        getInstrumentation().getUiAutomation().executeShellCommand(command);
        // wait a bit until the command is finished
        SystemClock.sleep(1000);
    }