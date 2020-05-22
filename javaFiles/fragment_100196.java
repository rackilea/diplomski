@AfterMethod
    public void setTestResult(ITestResult result) throws IOException {

        String screenShot = CaptureScreenShot.captureScreen(wd, CaptureScreenShot.generateFileName(result));

        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, result.getName());
            test.log(Status.FAIL,result.getThrowable());
            test.fail("Screen Shot : " + test.addScreenCaptureFromPath(screenShot));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, result.getName());
            test.pass("Screen Shot : " + test.addScreenCaptureFromPath(screenShot));
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test Case : " + result.getName() + " has been skipped");
        }

        extent.flush();
        wd.quit();
    }