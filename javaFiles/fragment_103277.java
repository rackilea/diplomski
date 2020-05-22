for (PkgDescriptor descriptor : myCCDirs) {
    ...
    // --- instantiate new ROOT manager
    myRootManagers[i] = new PackageManager(getConfig(), loggerPac, descriptor);
    // --- start it
    myRootManagers[i].start();
}