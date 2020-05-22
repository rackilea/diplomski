public byte[] internalize(byte[] bytes) {
 ByteBuffer wrapped = ByteBuffer.wrap(bytes);
 if(cache.containsKey(wrapped)) {
  wrapped = cache.get(wrapped).get();
 }
 else {
  cache.put(wrapped, new WeakReference<ByteBuffer>(wrapped);
 }
 return wrapped.array();
}