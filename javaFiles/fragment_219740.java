public void resourceChanged(IResourceChangeEvent event) {
    if (event == null || event.getDelta() == null)
        return;
    event.getDelta().accept(new IResourceDeltaVisitor() {
        public boolean visit(IResourceDelta delta) throws CoreException {
            if (delta.getKind() == IResourceDelta.OPEN)
                final IResource resource = delta.getResource();
                if (!(resource instanceof IProject))
                    return;
               //do your stuff and check the project is opened or closed
        }
}