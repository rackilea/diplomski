@Override
protected void load(WebDriver driver) {
   LandingPageEntry.load();
   testLandingPageEntry(driver)
   ...
   StandardSMMEntry.load();
   testStandardSMMEntry(driver);
   ...