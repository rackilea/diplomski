String uri = "platform:/resource/project/path/to/file.ext";
IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri));
IFileState[] states = file.getHistory(new NullProgressMonitor());
if (states.length > 0) {
    IFileState lastFromHistory = states[0];
    ResourceSet set = new ResourceSetImpl();
    Resource res = set.createResource(URI.createURI(uri));
    res.load(lastFromHistory.getContents(), Collections.emptyMap());
}