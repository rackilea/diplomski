public interface IModelBasedWizard {

    public void addWizardPage(IWizardPage page);

    public IStatus getWizardStatus();

    public void bindModel(IModel model);
}