@Override
public String getWindowTitle() {
    if (getContainer() != null) {
        IWizardPage currentPage = getContainer().getCurrentPage();

        if (currentPage == wizardPage1)
            return "title1";
        else if (currentPage == wizardPage2)
            return "title2";
    }

    return "otherwise";
}