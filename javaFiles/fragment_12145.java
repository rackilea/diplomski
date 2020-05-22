public abstract class BasePage {
    private IOSDriverManager driverManager;

    public BasePage(IOSDriverManager driverManager) {
        this.driverManager = driverManager;
        initElements();
    }

    private void initElements() {
        PageFactory.initElements(new AppiumFieldDecorator(driverManager.getDriver()), this);
    }

    protected IOSDriver<IOSElement> getDriver() {
        return driverManager.getDriver();

    }
}