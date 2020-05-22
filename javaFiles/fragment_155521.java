Iterator it = selection.iterator();
    while(it.hasNext()){
    Object firstElement = it.next();
if (firstElement != null) {
    if (firstElement instanceof IAdaptable) {
        IProject project = (IProject) ((IAdaptable) firstElement).getAdapter(IProject.class);
        IPath path = project.getFullPath();
        IPath location = project.getLocation();
    }
}
    }