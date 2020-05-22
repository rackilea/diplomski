public class MyImportWizard extends Wizard implements IImportWizard {

    private IProject project = null;

    private boolean flag = false;

    public void addPages() {
        if(!flag)
            System.out.println("Hello");
    }

    public void createPageControls(Composite pageContainer) {
        if(flag){
            getShell().close();
            return;
        }
        super.createPageControls(pageContainer);
    }

    public void init(IWorkbench workbench, IStructuredSelection selection) 
    {
        project = null;
        if (selection.size() > 0) {
            Object obj = selection.getFirstElement();
            if (obj instanceof IResource) {
                IResource resource = (IResource)obj;
                if (obj instanceof IProject)
                    project = (IProject)obj;
                else
                    project = resource.getProject();
            }
        }

        if (project == null) {
            MessageDialog.openError(
                    getShell(),
                    "GetPack Wizard", 
                    "You must run this wizard from a project."
            );
            flag = true;
        }
    }

    @Override
    public boolean performFinish() {
        return true;
    }
}