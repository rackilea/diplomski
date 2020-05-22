class MyLaunchListener implements ILaunchListener {

    @Override
    public void launchAdded(ILaunch launch) {
        System.out.println("Launching!");
        // do stuff here
    }

    ...
}

ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
manager.addLaunchListener(new MyLaunchListener());