private Map<String, Object> attributes = new HashMap<String, Object>();
 ...

 public Object getAttribute(String string) {
    return attributes.get(this);
  }

  public Enumeration<String> getAttributeNames() {
    return (Enumeration<String>) attributes.keySet();
  }

  public void setAttribute(String string, Object o) {
    attributes.put(string, o);
  }

  public void removeAttribute(String string) {
    attributes.remove(string);
  }