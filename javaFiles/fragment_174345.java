public enum Status { NEW, OLD, NEITHER }

private Status isOldMailer(File mailerFolder) {
    File localBuildAndDeploy = new File(mailerFolder,"test/local-build-deploy.cmd");
    if (localBuildAndDeploy.exists())
        return Status.NEW;
    else if (/*Something else*/)
        return Status.OLD
    else
        return Status.NEITHER;
}