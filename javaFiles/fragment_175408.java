if (!context.isUpdateInstallation()) {
    ApplicationRegistry.ApplicationInfo[] infos = 
        ApplicationRegistry.getApplicationInfoById(context.getApplicationId());
    if (infos.length > 0) {
        return infos[0].getInstallationDirectory().getPath();
    }
}
return null;