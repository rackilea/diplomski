public class Wizard {

    public void addWizardPage(IWizardPage page) {
        pages.add(page);
        page.createContent(this);
    }

    public IStatus getWizardStatus() {
        List<IStatus> stati= new ArrayList<Status>();
        for (IWizardPage page : pages) {
            stati.add(page.getStatus());
        }
        return stati;
    }
}