try {
final IWorkbenchPartSite targetSite = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getPartService()
.getActivePart().getSite();

    if(targetSite!=null){ 
    System.out.println("TargetSite obtained");
    organizeImports(wiProject, targetSite);
    }

} catch (Exception e) {
// TODO Auto-generated catch block
e.printStackTrace();
} 



public void organizeImports(final IProject project, final IWorkbenchSite targetSite) throws CoreException {
Runnable job = new Runnable() {

@Override
public void run() {
    OrganizeImportsAction org = new OrganizeImportsAction(targetSite);
        try {
          IJavaProject prj = null;
          if (project.hasNature("org.eclipse.jdt.core.javanature")) {
          prj = JavaCore.create(project);
        }

        IStructuredSelection selection = new StructuredSelection(prj);
        org.run(selection);
             } catch (CoreException ce) {
        ce.printStackTrace();
    }

}

};
    this.getShell().getDisplay().syncExec(job);
}