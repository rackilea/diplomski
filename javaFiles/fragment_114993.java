IEditorPart editor = get the editor

IEditorInput editorInput = editor.getEditorInput();

if (editorInput instanceof IFileEditorInput)
 {
   IFile file = ((IFileEditorInput)editorInput).getFile();

   // TODO handle file
 }