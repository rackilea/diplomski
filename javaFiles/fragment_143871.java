// Assume MyPageObjectPage is your custom page object class.
// Of course, your constructor would likely be different, so
// you would need to change this to match your actual class
// structure.
// Further assume that driver is your IWebDriver instance.
MyPageObjectPage page = new MyPageObjectPage();
PageFactory.InitElements(driver, page);