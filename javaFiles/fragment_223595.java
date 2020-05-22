public class WorkViewModel extends BaseObservable implements AutoCloseable
{
    private long _nativeHandle;
    Cleaner.Cleanable cleanable;

    public WorkViewModel(Database database, int workId)
    {
      _nativeHandle = create(database.getNativeHandle(), workId);
      cleanable = createCleanable(this, _nativeHandle);
    }
    private static Cleaner.Cleanable createCleanable(Object o, long _nativeHandle) {
        return Cleaner.register(o, () -> delete(_nativeHandle));
    }

    @Override
    public void close() {
        cleanable.clean();
    }

    private static native long create(long databaseHandle, int workId);
    static native void delete(long nativeHandle);

    @Bindable
    public native int getWorkId();
    public native void setWorkId(int workId);

}