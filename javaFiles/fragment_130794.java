public IWizardPage getNextPage() 
{
    if (selectedNode == null) {
        return null;
    }

    boolean isCreated = selectedNode.isContentCreated();

    IWizard wizard = selectedNode.getWizard(); // THIS WILL CALL THE INIT

    if (wizard == null) {
        setSelectedNode(null);
        return null;
    }

    if (!isCreated) {
        // Allow the wizard to create its pages
        wizard.addPages();              // THIS IS ADDING THE EXTRA PAGES
    }

    return wizard.getStartingPage();
}