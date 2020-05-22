private IDocumentProvider createDocumentProvider(IEditorInput input) {
    if(input instanceof IFileEditorInput){
        return new XMLTextDocumentProvider();
    } else if(input instanceof IStorageEditorInput){
        return new XMLFileDocumentProvider();
    } else {
        return new XMLTextDocumentProvider();
    }
}

@Override
protected final void doSetInput(IEditorInput input) throws CoreException {
    setDocumentProvider(createDocumentProvider(input));
    super.doSetInput(input);
}