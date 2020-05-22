IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);

    try {
        IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

        ISelection selection = workbenchWindow.getSelectionService().getSelection();
        ITextSelection textSelection;
        if (selection instanceof ITextSelection)
            textSelection = (ITextSelection) selection;
        else
            throw new RuntimeException("No text selection");

        IEditorInput editorInput = workbenchWindow.getActivePage().getActiveEditor().getEditorInput();
        ICompilationUnit compilationUnit = JavaUI.getWorkingCopyManager().getWorkingCopy(editorInput);
        IJavaElement elementWithCursorInside = compilationUnit.getElementAt(textSelection.getOffset());
        ISourceReference sourceReference;
        if (elementWithCursorInside instanceof ISourceReference)
            sourceReference = (ISourceReference) elementWithCursorInside;
        else
            throw new RuntimeException("Not an ISourceReference");

        MessageDialog.openInformation(window.getShell(), "Source Code of the Method", sourceReference.getSource());

    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;