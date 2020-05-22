public class ConfigurationListener implements IConfigurationListener {

    @Override
    public void onConfigurationSuccess(ITestResult itr) {
        Logger.log("LOG From ConfigurationListener onConfigurationSuccess:: ");
    }

    @Override
    public void onConfigurationFailure(ITestResult itr) {
        Logger.log("LOG From ConfigurationListener onConfigurationFailure:: ");     
    }

    @Override
    public void onConfigurationSkip(ITestResult itr) {
        Logger.log("LOG From ConfigurationListener onConfigurationSkip:: ");        
    }

}