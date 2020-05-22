public List<T> getValues() {
  try {
    return getObjects();
  } catch (Exception e) {
    e.printStackTrace();
  } finally {
    System.out.println("In finally");
  }
  return null; // <-- there was an Exception. Default return.
}

protected abstract List<T> getObjects()
    throws Exception;