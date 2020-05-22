IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

    IEditorReference [] editors = page.getEditorReferences();

    for (IEditorReference editorReference : editors) {
                try {
                    IEditorInput editorInput = editorReference.getEditorInput();
                    if (editorInput instanceof IFileEditorInput) {
                        IFileEditorInput fileEditorInput = (IFileEditorInput) editorInput;
                        IFile file = fileEditorInput.getFile();

                        //Once you get the file, convert it into java.io.File and you can get all the metadata from file
//Write your own logic to print and to check



                    }
                } catch (PartInitException e) {
                    e.printStackTrace();
                }

     }