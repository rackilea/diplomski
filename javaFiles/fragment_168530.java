private LoginPageUi getUi(String pageType) {
    if (pageType.equals(DuoLoginPageUi.getPageType())) {
        return new DuoLoginPageUi();
    }
    else if (pageType.equals(UnoLoginPageUi.getPageType())) {
        return new UnoLoginPageUi;
    }
    return null;
}