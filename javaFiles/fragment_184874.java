public class PreviousVersionCheck extends CustomActionBase{

    @Override
    public void install(InstallerProxy proxy) throws InstallException {

     boolean oldVersionRunning = isOldVersionRunning();//Logic to check if old version running.
     proxy.setVariable("$OLD_VERSION_RUNNING$",oldVersionRunning)
 }
}