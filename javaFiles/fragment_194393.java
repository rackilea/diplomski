AtomicReference<Foo> holder = new AtomicReference<>();
map.computeIfAbsent(key, k -> {
  holder.set(/* compute the value */);
  return null;  // returning null means no value is stored.
});
/* Use holder.get() to access value */