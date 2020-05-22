public class test implements ITestListener {

    @Override
    public void onTestSkipped(ITestResult result) {
        ... do Your stuff for skip tests extent report here ...
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ... do Your stuff for passed test extent report here ...
    }

    ... and all other methods are automatically implemented, and You don't have to check status, test will automatically enter proper methods. 


    @Override
    public void onStart(ITestContext context){
          //init extent reports... on whatever way You do it...
    }


    @Override
    public void onFinish(ITestContext context){
        report.endTest(extentTest);
        report.flush(); 
    }

}