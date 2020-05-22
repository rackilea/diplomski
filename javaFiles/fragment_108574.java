public interface DataObject<T extends DataObject<T>> {
  public void copyFrom(DataObject source);
  public void copyFromImpl(T source);
}

public class DataObjectImpl implements DataObject<DataObjectImpl> {
  public void copyFrom(final DataObject source) { ... }
  public void copyFromImpl(final DataObjectImpl source) { ... }
}