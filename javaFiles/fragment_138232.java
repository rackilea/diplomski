public class MyEditor extends EditorPart {
    private final Display display = Display.getCurrent();

    private IResourceChangeListener editorCloser = new IResourceChangeListener() {
        public void resourceChanged(IResourceChangeEvent event) {
            final IResource closingProject = event.getResource();
            Display.getDefault().asyncExec(new Runnable(){
                public void run() {
                    for (IWorkbenchPage page : getSite().getWorkbenchWindow().getPages()) {
                        FileEditorInput editorInput = (FileEditorInput) MyEditor.this.getEditorInput();
                        if (editorInput.getFile().getProject().equals(closingProject))
                            page.closeEditor(page.findEditor(editorInput), true);
                    }
                }
            });
        }   
    };

    public void init(IEditorSite site, IEditorInput input) throws PartInitException {
        [...]
        ResourcesPlugin.getWorkspace().addResourceChangeListener(editorCloser,
            IResourceChangeEvent.PRE_CLOSE | IResourceChangeEvent.PRE_DELETE);
    }

    public void dispose() {
        super.dispose();
        ResourcesPlugin.getWorkspace().removeResourceChangeListener(editorCloser);
    }
}