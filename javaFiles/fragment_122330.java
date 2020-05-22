public class SettingsMainPage{

    public SettingsMainPage(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        System.out.println("Settings Main page class has been initialized");
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
    AndroidElement header;
    @AndroidFindBy(id= "android:id/title")
    List<AndroidElement> titles;
    @AndroidFindBy(id= "android:id/summary")
    List<AndroidElement> summaries;

    public boolean pageLoaded() {
       try{

           (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfElementLocated(header));
           return header.isDisplayed();
       }
       catch(Exception e){
           return false;
       }
    }

}