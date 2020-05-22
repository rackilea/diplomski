class Container<T> {
  private final Map<String, T> dataObject;

  public Map<String, T> getDataObject() {
    return dataObject;
  }

  public void addDataObject(final String key, final T value) {
    dataObject.put(key, value);
  }

}