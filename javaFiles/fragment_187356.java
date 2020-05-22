String fileContents = ...;
IFile file = ...;
file.create(new ByteArrayInputStream(fileContents.getBytes()), true, null);
FileEditorInput input = new FileEditorInput(file);
PlatformUI.getWorkbench().getActiveWorkbenchWindow().
    getActivePage().openEditor(input, THE_EDITOR_ID);