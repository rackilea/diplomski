if (fileToOpen.exists() && fileToOpen.isFile()) {
     String path = //Path for that to file to open;
     IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
     URI fromString = org.eclipse.core.runtime.URIUtil.fromString("file://" + path);
     try {
         IEditorPart openEditor = IDE.openEditor(page, fromString, Editor.ID, true);
         IEditorInput editorInput = openEditor.getEditorInput();
         //editorInput.
     } catch ( PartInitException e ) {
         //Put your exception handler here if you wish to.
     }
 }