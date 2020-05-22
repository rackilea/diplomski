public class Wrapper<T> {
  private WeakReference<T> thisReference;
  private ConcurrentLinkedQueue<WeakReference<Object>> references = 
    new ConcurrentLinkedQueue<>();

  public T getObject(Object obj) {
    T thisObject = thisReference.get();
    if(thisObject != null) {
      references.offer(new WeakReference(obj));
    }
    return thisObject;
  }

  public int referenceCount() {
    if(thisReference.get() == null) {
      references.clear();
      return 0;
    } else {
      Iterator<WeakReference<Object>> iterator = references.iterator();
      while(iterator.hasNext()) {
        WeakReference<Object> reference = iterator.next();
        if(reference.get() == null) {
          iterator.remove(); 
        }
      }
      return references.size();
    }
  }
}