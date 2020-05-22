IEditorPart  editorPart =
getSite().getWorkbenchWindow().getActivePage().getActiveEditor();

if(editorPart  != null)
{
    IFileEditorInput input = (IFileEditorInput)editorPart.getEditorInput() ;
    IFile file = input.getFile();
    IProject activeProject = file.getProject();
    String activeProjectName = activeProject.getName();
    //... use activeProjectName 
}