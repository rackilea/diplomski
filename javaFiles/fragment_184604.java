public class MyBrowserComp extends Composite {

    private String pathToXulrunner = "C:\\path\\to\\xulrunner";`

    private Browser browser;

    public MyBrowserComp(..) {
        System.setProperty("org.eclipse.swt.browser.XULRunnerPath", pathToXulrunner);
        browser = new Browser(this, SWT.MOZILLA);
    }
}