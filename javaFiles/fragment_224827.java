// uninteresting methods left out for brevity

class StringEditorInput implements IStorageEditorInput {
  @Override
  public boolean exists() {
    return true;
  }

  @Override
  public IStorage getStorage() throws CoreException {
    return new StringStorage();
  }
}

class StringStorage implements IStorage {
  @Override
  public InputStream getContents() throws CoreException {
    return new ByteArrayInputStream( "Hello editor!".getBytes( StandardCharsets.UTF_8 ) );
  }
}

String editorId = "org.eclipse.ui.DefaultTextEditor";
IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
IEditorPart editor = IDE.openEditor( page , new StringEditorInput(), editorId );