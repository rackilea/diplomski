public interface DataService {
  public ListenableFuture<Data> getData();
}

public abstract class LocalDataService implements DataService {
  public ListenableFuture<Data> getData() {
    SettableFuture<Data> result = SettableFuture.create();
    try {
      Data theData = computeData();
      result.set(theData);
    } catch(Throwable t) {
      result.setException(e);
    }
    return result;
  }

  protected abstract Data computeData() throws Throwable;
}