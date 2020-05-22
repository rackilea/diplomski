class StorageEditorInput extends PlatformObject implements IStorageEditorInput {
    private IStorage fStorage;

    public StorageEditorInput(IStorage storage) {
        fStorage = storage;
    }

    @Override
    public IStorage getStorage() {
        return fStorage;
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return null;
    }

    @Override
    public String getName() {
        return getStorage().getName();
    }

    @Override
    public IPersistableElement getPersistable() {
        return null;
    }

    @Override
    public String getToolTipText() {
        return getStorage().getFullPath().toOSString();
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof StorageEditorInput &&
         getStorage().equals(((StorageEditorInput)object).getStorage());
    }

    @Override
    public int hashCode() {
        return getStorage().hashCode();
    }

    @Override
    public boolean exists() {
        return true;
    }
}