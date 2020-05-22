public void add(T object) {
    if (mOriginalValues != null) {
    synchronized (mLock) {
        mOriginalValues.add(object);
        if (mNotifyOnChange) notifyDataSetChanged();
    }
 } else {
    mObjects.add(object);
    if (mNotifyOnChange) notifyDataSetChanged();
 }