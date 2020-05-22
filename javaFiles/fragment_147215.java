T objectToWatch = ...;
ReferenceQueue<T> referenceQueue = new ReferenceQueue<T>();
new PhantomReference<T>(objectToWatch, referenceQueue);

// Later on, probably in another thread...
Reference<? extends T> nextReference = referenceQueue.remove();
// Tidy up!