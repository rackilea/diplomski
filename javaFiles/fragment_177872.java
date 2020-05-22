Object deserialized = ois.readObject();

if (deserialized instanceof PersistentTime) {
  PersistentTime time = (PersistentTime)deserialized;
  // do something with time...
} else if (deserialized instanceof SomethingElse) {
  ...
} else if (...) {
  ...
}