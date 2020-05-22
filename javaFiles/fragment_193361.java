public class InterpretCodeHandler extends AbstractHandler implements IHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {

        IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
        IFile file = (IFile) activeEditor.getEditorInput().getAdapter(IFile.class);
        if (file != null) {
            IProject project = file.getProject();



            if (activeEditor instanceof XtextEditor) {
                ((XtextEditor)activeEditor).getDocument().readOnly(new IUnitOfWork<Boolean, XtextResource>() {

                    @Override
                    public Boolean exec(XtextResource state)
                            throws Exception {
                        // TODO your code here
                        return Boolean.TRUE;
                    }
                });

            }
        }
        return null;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}