IEditorReference[] ref = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
    .getActivePage().getEditorReferences();
    boolean isDirty = false;
    for (IEditorReference iEditorReference : ref) {
        if (iEditorReference.isDirty())
            isDirty = true;
    }