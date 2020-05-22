public static <T> T initElements(WebDriver driver, Class<T> pageClassToProxy) {
    T page = instantiatePage(driver, pageClassToProxy);
    initElements(driver, page);
    return page;
}

// translate to

HomePage homePage = new HomePage();
PageFactory.initElements(driver, homePage);
return homePage;