IStructuredSelection structured = (IStructuredSelection)selection;

for (Object elem : structured.toList()) {
    IJavaProject project = null;

    if (elem instanceof IJavaProject) {
        project = (IJavaProject)elem;
    } else if (elem instanceof IProject) {
        project = (IJavaProject)JavaCore.create((IProject)elem);
    }

    if (project != null) {
       ... your code
    }        
}