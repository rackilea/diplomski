class FileStorage implements IStorage {
  private final FileStoreEditorInput editorInput;

  FileStorage( FileStoreEditorInput editorInput ) {
    this.editorInput = editorInput;
  }

  @Override
  public <T> T getAdapter( Class<T> adapter ) {
    return Platform.getAdapterManager().getAdapter( this, adapter );
  }

  @Override
  public boolean isReadOnly() {
    return false;
  }

  @Override
  public String getName() {
    return editorInput.getName();
  }

  @Override
  public IPath getFullPath() {
    return new Path( URIUtil.toFile( editorInput.getURI() ).getAbsolutePath() );
  }

  @Override
  public InputStream getContents() {
    try {
      return editorInput.getURI().toURL().openStream();
    } catch( IOException e ) {
      throw new UncheckedIOException( e );
    }
  }
}